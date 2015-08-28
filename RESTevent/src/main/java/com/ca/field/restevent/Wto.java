package com.ca.field.restevent;

import java.io.IOException;

import com.nimsoft.nimbus.NimAlarm;
import com.nimsoft.nimbus.NimClientSession;
import com.nimsoft.nimbus.NimException;
import com.nimsoft.nimbus.NimLog;
import com.nimsoft.nimbus.NimPost;
import com.nimsoft.nimbus.NimProbe;
import com.nimsoft.nimbus.NimSession;
import com.nimsoft.nimbus.NimConfig;
import com.nimsoft.nimbus.NimObjectSender;
import com.nimsoft.nimbus.PDS;


public class Wto {

    // Name the probe
    static String myName = "CAWTO";
    static String myVersion = "01.A";
    static String myCompany = "CA Technologies";

    /** How to declare the logger. */
    static NimLog logger = NimLog.getLogger(Wto.class);

    static NimProbe probe = null;

    static String sId = null;
    

    /* List of severities
    	NIML_CLEAR = 0;
    	NIML_INFORMATION = 1;
    	NIML_WARNING = 2;
    	NIML_MINOR = 3;
    	NIML_MAJOR = 4;
    	NIML_CRITICAL = 5;
    */
    /**
     * WTO event method.
     * @param Severity
     * @param sMessage
     * @param sSubsystem
     * @param sSuppressionid
     * @param sSource
     * @throws NimException 
     */
    public static String event(int iSeverity, String sMessage, String sSubsystem, String sSuppressionid, String sSource) throws NimException {
    		NimAlarm alarm = new NimAlarm(iSeverity, sMessage, sSubsystem, sSuppressionid, sSource);
            String id = alarm.send();
            logger.log(NimLog.DEBUG, "Alarm sent id: " + id);
            alarm.close();
            return id;
           }
}
