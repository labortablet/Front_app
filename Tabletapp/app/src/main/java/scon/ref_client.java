package scon;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import exceptions.SBSBaseException;
import imports.User;

public class ref_client {
	public static void main(String[] args) {
		System.out.println("Starting Test!");
		URL url = null;
		try {
			url = new URL("https://lablet.vega.uberspace.de/scon/db.cgi");
			//url = new URL("https://lablet.vega.uberspace.de/scon/json_bounce.cgi");
		} catch (MalformedURLException e) {
			System.exit(1);
		};
        System.out.println("URL not malformed");
        //these need to be set on server as well!
		String username = "fredi@uni-siegen.de";
		String password = "test";
        System.out.println("Username and PW set");
        User user = new User(username, password);
		ServerDatabaseSession SDS = new ServerDatabaseSession(url, user);
		try {
            System.out.println("Start session");
            SDS.start_session();
            System.out.println("Sesstion started");
            System.out.println("Get Remote Projects");
            LinkedList<RemoteProject> remoteProject_list = SDS.get_projects();
            System.out.println("Got Remote Projects");
            System.out.println("Get Remote Experiments");
            LinkedList<RemoteExperiment> remoteExperiment_list = SDS.get_experiments();
            System.out.println("Got Remote Experiments");
            System.out.println("Printing them");
            System.out.println(remoteProject_list);
			System.out.println(remoteExperiment_list);
		} catch (SBSBaseException e) {
			System.out.println(e);
		};
	};
};
