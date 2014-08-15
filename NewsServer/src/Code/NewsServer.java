package Code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import service.Request;
import Views.Principal;
import java.io.*;
import static java.lang.System.exit;
import java.net.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JOptionPane;
import org.apache.commons.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NewsServer {
    public static void main(String[] argv) throws ParseException, Exception {
           
        Principal p = new Principal();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
    }
}
