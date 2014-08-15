package Code;

import Views.Notizas;
import Views.Principal;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.io.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.*;

public class NewsClient {

    public static void main(String[] args) {
        Principal p = new Principal();

        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.setTitle("Notizas");

    }
}
