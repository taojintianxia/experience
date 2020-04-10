package com.github.taojintianxia.conuporpia.shardingsphere.shardingcore.rawjdbc.masterslave;

import com.github.taojintianxia.cornucopia.shardingsphere.common.constant.TableConstant;
import com.github.taojintianxia.cornucopia.shardingsphere.common.entity.OrderItem;
import com.github.taojintianxia.cornucopia.shardingsphere.common.enums.ShardingType;
import com.github.taojintianxia.cornucopia.shardingsphere.common.factory.YamlDataSourceFactory;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Nianjun Sun
 * @date 2020/4/9 22:49
 */
@Slf4j
public class MasterSlaveDemo {

    private static final String SQL = "SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id=i.order_id WHERE o.user_id=? AND o.order_id=?";

    public static void main(String... args) {
        try {
            DataSource dataSource = YamlDataSourceFactory.newInstance(ShardingType.MASTER_SLAVE);
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, 10);
            preparedStatement.setInt(2, 1001);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(resultSet.getLong(TableConstant.ORDER_ITEM_ORDER_ITEM_ID));
                orderItem.setOrderId(resultSet.getLong(TableConstant.ORDER_ITEM_ORDER_ID));
                orderItem.setUserId(resultSet.getInt(TableConstant.ORDER_ITEM_USER_ID));
                orderItem.setStatus(resultSet.getString(TableConstant.ORDER_ITEM_STATUS));
                log.info("order item is : {}", orderItem);
            }
        } catch (SQLException | IOException e) {
            log.error("got an error ", e);
        }
    }
}