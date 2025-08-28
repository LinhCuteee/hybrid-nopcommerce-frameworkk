package commons;

public class GlobalConstants {
// System Information
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME      = System.getProperty("os.name");
    public static final String JAVA_VERSION      = System.getProperty("java.version");
    public static final String SEPARATOR      = System.getProperty("file.separator");

// Application - User URLs
    public static final String DEV_USER_URL     = "https://demo.nopcommerce.com/";
    public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
    public static final String LIVE_USER_URL    = "http://live.techpanda.org/";

//  Application - Admin URLs
    public static final String DEV_ADMIN_URL     = "http://dev.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL    = "http://live.techpanda.org/index.php/backendlogin";

    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMIN_PASSWORD = "guru99com";

//  Wait Information
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT  = 30;

//  Download / Upload Path
    public static final String UPLOAD_PATH   = PROJECT_PATH + SEPARATOR+"uploadFiles"+SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR+"downloadFiles"+SEPARATOR;

//  Retry Failed Test
    public static final int RETRY_NUMBER = 3;

//  Browser Logs / Extensions
    public static final String BROWSER_LOG_PATH       = PROJECT_PATH +SEPARATOR+ "browserLogs"+SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR+"browserExtensions"+SEPARATOR;

//  HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + SEPARATOR+"htmlReportNG"+SEPARATOR;
    public static final String EXTENT_PATH    = PROJECT_PATH + SEPARATOR+"htmlExtent"+SEPARATOR;
    public static final String ALLURE_PATH    = PROJECT_PATH + SEPARATOR+"htmlAllure"+SEPARATOR;

//  Data Test / Environment Config
    public static final String DATA_TEST_PATH       = PROJECT_PATH + SEPARATOR+"dataTest"+SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR+"environmentConfig"+SEPARATOR;


    public static final String JIRA_SITE_URL    = "https://automationfccom.atlassian.net/";
    public static final String JIRA_USERNAME    = "linhnguyenn.12052003@gmail.com";
    public static final String JIRA_API_KEY     = "ATATT3xFfGF0lmornXpRdxLo0E3xdiASOwAFyBspks8gbi0Qb7I-jcXerndUpRSft6csi9Tw9X3IERbA-bXWnaZ-qGU1iAFIHJ9AWZrpdC94a0qc0Za_aEF9YH-ef6uSDJfkUwCNa777e7Drv2W38I3F2y0EevAsGleqG5q9vlL5FS6Ohc4J67E=F38C3004";
    public static final String JIRA_PROJECT_KEY     = "SCRUM";





}
