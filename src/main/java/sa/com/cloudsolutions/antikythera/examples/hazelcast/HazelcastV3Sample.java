package sa.com.cloudsolutions.antikythera.examples.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;

/**
 * Sample Hazelcast 3.x code for migration testing.
 * This demonstrates patterns that need to be migrated to Hazelcast 4.x.
 */
public class HazelcastV3Sample {

    public void useStaticMethods() {
        // These static methods were removed in 4.x
        IMap<String, String> map = Hazelcast.getMap("my-map");
        IQueue<String> queue = Hazelcast.getQueue("my-queue");

        map.put("key", "value");
        queue.offer("item");
    }

    public Config configureWithGroupConfig() {
        Config config = new Config();

        // GroupConfig deprecated in 4.x, replaced with cluster name
        config.getGroupConfig().setName("my-cluster");
        config.getGroupConfig().setPassword("password");

        // This pattern needs migration
        config.setGroup(new com.hazelcast.config.GroupConfig("cluster", "pass"));

        return config;
    }

    public HazelcastInstance createInstance() {
        Config config = new Config();
        config.getGroupConfig().setName("test-cluster");

        return Hazelcast.newHazelcastInstance(config);
    }
}
