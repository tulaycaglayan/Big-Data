package com.bigdata.es.base;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class TestConnectionApi {
	 public static void main(String[] args) throws UnknownHostException {
	        Settings settings= Settings.builder()
	                .put("cluster.name","elasticsearch").build();

	    	TransportClient client= null;
	        try {
	            client = new PreBuiltTransportClient(settings)
	                    .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));//9300 port is for REST Api
	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        }
	        
	        List<DiscoveryNode> discoveryNodes = client.listedNodes();
	        
	        for ( int i =0; i<discoveryNodes.size(); i++){
	        	System.out.println(" Connection successful. Node : " + discoveryNodes.get(i) );
	        }
	        
	        client.close();
	 }
}
