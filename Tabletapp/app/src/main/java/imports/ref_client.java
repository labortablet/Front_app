package imports;

import exceptions.SBSBaseException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

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
		String user = "fredi@uni-siegen.de";
		String pw_h = "sad";
		ServerDatabaseSession SDS = new ServerDatabaseSession(url, user, pw_h);
		try {
			System.out.println(SDS.get_challenge());
		} catch (SBSBaseException e) {
			System.out.println(e);
		};
		try {
			LinkedList<RemoteProject> remoteProject_list = SDS.get_projects();
			LinkedList<RemoteExperiment> remoteExperiment_list = SDS.get_experiments();
			System.out.println(remoteProject_list);
			System.out.println(remoteExperiment_list);
		} catch (SBSBaseException e) {
			System.out.println(e);
		};
	};
};
