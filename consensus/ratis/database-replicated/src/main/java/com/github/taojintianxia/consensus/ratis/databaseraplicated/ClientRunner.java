package com.github.taojintianxia.consensus.ratis.databaseraplicated;

import com.github.taojintianxia.consensus.ratis.databaseraplicated.client.MySQLReplicatedClient;
import com.github.taojintianxia.consensus.ratis.databaseraplicated.api.client.RatisClient;

import java.io.IOException;

/**
 * @author Nianjun Sun
 * @date 2020/5/7 09:23
 */
public class ClientRunner {

    public static void main(String... args) throws IOException {
        RatisClient ratisClient = new MySQLReplicatedClient();
        String sql = "INSERT INTO t_order(order_id,user_id,address_id,status) VALUES(1, 1, 1, 'INIT')";
        ratisClient.run(sql);
    }
}
