package org.xframium.reporting;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.xframium.device.data.DataManager;

public class ExecutionContext
{
    private static transient ExecutionContext singleton = new ExecutionContext();
    private static transient DateFormat timeFormat = new SimpleDateFormat( "MM-dd_HH-mm-ss-SSS" );
    private File reportFolder = null;
    private String suiteName;
    private Date startTime;
    private Date endTime;
    private List<Map<String, Object>> executionSummary = new ArrayList<Map<String, Object>>( 10 );

    private ExecutionContext()
    {

    }

    public static ExecutionContext instance()
    {
        return singleton;
    }

    private transient List<ExecutionContextTest> executionList = new ArrayList<ExecutionContextTest>( 10 );

    public void addExecution( ExecutionContextTest test )
    {
        executionList.add( test );
        executionSummary.add( test.toMap() );
    }

    public boolean isEnabled()
    {
        return executionList != null && executionList.size() > 0;
    }

    public List<Map<String, Object>> getExecutionSummary()
    {
        return executionSummary;
    }

    public File getReportFolder()
    {
        if ( reportFolder == null )
            reportFolder = new File( DataManager.instance().getReportFolder(), timeFormat.format( new Date( System.currentTimeMillis() ) ) );
        return reportFolder;
    }

    public String getSuiteName()
    {
        return suiteName;
    }

    public void setSuiteName( String suiteName )
    {
        this.suiteName = suiteName;
        startTime = new Date( System.currentTimeMillis() );
    }

    public Date getStartTime()
    {
        return startTime;
    }

    public void setStartTime( Date startTime )
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime( Date endTime )
    {
        this.endTime = endTime;
    }
    
    

}
