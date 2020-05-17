package com.github.taojintianxia.consensus.ratis.databaseraplicated;

import com.github.taojintianxia.consensus.ratis.databaseraplicated.server.MySQLReplicatedServer;
import com.github.taojintianxia.consensus.ratis.databaseraplicated.server.RatisServer;

/**
 * @author Nianjun Sun
 * @date 2020/5/5 17:08
 */
public class Runner {

    public static void main(String... args) throws Exception {
        RatisServer ratisServer = new MySQLReplicatedServer();
        ratisServer.run();
    }
}
