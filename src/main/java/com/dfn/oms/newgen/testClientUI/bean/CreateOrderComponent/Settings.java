package com.dfn.oms.newgen.testClientUI.bean.CreateOrderComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Settings {
    //static Logger logger = Logger.getLogger("Settings");

    private static Properties   g_oProperties;
    private static String       sData;
    private static String       sSettingsFile;

    public  static String       WEBSERVICE_URL    = "";

    public static String        DB_CLASS            = "";
    public static String        DB_URL              = "";
    public static String        DB_USER             = "";
    public static String        DB_PASSWORD         = "";
    public static String        MIDDLEWARE = "";
    public static String        FILE_TYPE = "";
    public static String        IP = "";
    public static String           DELAY_BETWEEN_MESSAGE_MILISECOND   = "10";
    public static String          PORT = "";
    public static String          QNAME = "";
    public static String          SID = "";
    public static String          Q_USERNAME = "";
    public static String          Q_PASSWORD = "";
    public static String          Q_CONTEXT_FACTORY = "";
    public static String          Q_PROVIDER_URL = "";
    public static String          Q_CONNECTION_FACTORY = "";
    public static String          FIX_FILE = "";
    public static String          RERUN_INTERVAL = "";
    public static String          VALIDATE = "TRUE";
    public static String          MSG_TYPES = "";

    //public static com.isi.security.GNUCrypt cripto = new GNUCrypt();
    private static String key = "@1B2c3D4e5F6g7H8";

    public static void LoadSettings(){
        DB_CLASS                    = getString("DB_CLASS");
        DB_URL                      = getString("DB_URL");
        DB_USER                     = getString("DB_USER");
        DB_PASSWORD                 = getString("DB_PASSWORD");
        MIDDLEWARE                     = getString("MIDDLEWARE");
        FILE_TYPE                     = getString("FILE_TYPE");
        IP                     = getString("IP");
        PORT                   = getString("PORT");
        DELAY_BETWEEN_MESSAGE_MILISECOND          = getString("DELAY_BETWEEN_MESSAGE_MILISECOND");
        QNAME          = getString("QNAME");
        SID          = getString("SID");
        Q_USERNAME = getString("Q_USERNAME");
        Q_PASSWORD = getString("Q_PASSWORD");
        Q_CONTEXT_FACTORY = getString("Q_CONTEXT_FACTORY");
        Q_PROVIDER_URL = getString("Q_PROVIDER_URL");
        Q_CONNECTION_FACTORY = getString("Q_CONNECTION_FACTORY");
        FIX_FILE = getString("FIX_FILE");
        RERUN_INTERVAL = getString("RERUN_INTERVAL");
        MSG_TYPES = getString("MSG_TYPES");
        if (getString("VALIDATE") != null) {
            VALIDATE = getString("VALIDATE");
        }
/*        try {
            //DB_PASSWORD                 = cripto.decrypt(key, getString("DB_PASSWORD"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }


    public static void Load(String file){
        InputStream oIn;
        try {

            sSettingsFile   = file;
            g_oProperties   = new Properties();
            oIn             = new FileInputStream(sSettingsFile);
            g_oProperties.load(oIn);
            oIn.close();
        }
        catch(Exception e){
            //logger.debug("Error loading Settings File.");
            System.out.println("Error loading Settings File." + e);
            System.exit(0);
        }
        oIn = null;
    }


    public static void setSettingsFile(String file){
        sSettingsFile = file;
    }

    public static String getString(String s){
        try {
            sData = g_oProperties.getProperty(s);
            return sData;
        }
        catch(Exception e){
            //logger.debug("Error loading Property : " + s);
            return null;
        }
    }

    public static String getProperty(String s){
        try {
            sData = g_oProperties.getProperty(s);
            return sData;
        }
        catch(Exception e){
            //logger.debug("Error loading Property : " + s);
            return "";
        }
    }

    public static int getInt(String s){
        try {
            sData = g_oProperties.getProperty(s).trim();
            return (Integer.parseInt(sData));
        }
        catch(Exception e){
            //logger.debug("Error loading Property : " + s);
            return 0;
        }
    }

    private static long getLong(String s){
        try {
            sData = g_oProperties.getProperty(s).trim();
            return (Long.parseLong(sData));
        }
        catch(Exception e){
            //logger.debug("Error loading Property : " + s);
            return 0;
        }
    }

    public static void setProperty(String key, String value) {
        g_oProperties.setProperty(key, value);
    }

    public static List getMsgTypes() {
        if (MSG_TYPES == null || MSG_TYPES.isEmpty()) {
            return new ArrayList();
        } else {
            return Arrays.asList(MSG_TYPES.split(","));
        }
    }

    public static void saveLastSeq(int sequence) {
        PrintWriter out;
        try {
            out = new PrintWriter("conf/sequence.txt");
            //out = new FileOutputStream("conf/sequence.txt");
            out.print(String.valueOf(sequence));
            out.close();
        }
        catch(Exception e) {
        }
        out = null;
    }

    public static int getLastSeq() {
        int lastSeq = 0;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("conf/sequence.txt"));;
            lastSeq = Integer.parseInt(in.readLine().trim());
            in.close();
        } catch (Exception e) {
        }
        in = null;
        return lastSeq;
    }
}
