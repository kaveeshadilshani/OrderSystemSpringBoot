package com.hellokoding.springboot.bean;




/**
 * Created by samurdiw on 7/27/2016.
 */
public interface OMSConst {
    public static final String OMS_MESSAGE_PROTOCOL_PREFIX_JPATH = "$.HED.msgTyp";
    public static final String OMS_MESSAGE_PROTOCOL_PREFIX = "\"msgTyp\":";
    public static final String RUNTIME_CUSTOM = "CUSTOM";
    public static final String FLAG_RUNTIME = "RUNTIME";
    public static final String KEY_SEPARATOR = "~";

    public static final int SERVICE_ID_CREATE_ORDER_NEW = 2;
    public static final int SERVICE_ID_CASH_TRANSFER = 12;
    public static final int SERVICE_ID_CREATE_ORDER_CHANGE = 15;
    public static final int SERVICE_ID_CREATE_ORDER_CANCEL = 16;
    public static final int SERVICE_ID_REVERSE_ORDER = 17;
    public static final int SERVICE_ID_MANUAL_ORDER_EXECUTION = 18;
    public static final int SERVICE_ID_ORDER_EXPIRE = 19;
    public static final int SERVICE_ID_REVERSE_EXECUTION = 20;
    public static final int SERVICE_ID_ADD_PLEDGE = 27;
    public static final int SERVICE_ID_APPROVE_PLEDGE = 28;
    public static final int SERVICE_ID_TEST_JMS = 5;
    public static final int SERVICE_ID_STAT_MON = 6;
    public static final int SERVICE_ID_ORDER_LIST = 7;
    public static final int SERVICE_ID_APROVE_ORDER = 21;
    public static final int SERVICE_ID_RESEND_ORDER = 42;
    public static final int SERVICE_ID_WEEKLY_RECON = 53;
    public static final int SERVICE_ID_SUBSCRIPTION_REQUEST = 56;
    public static final int SERVICE_ID_CORPORATE_ACTION = 55;
    public static final int SERVICE_ID_APPROVE_SUBSCRIPTION = 57;
    public static final int SERVICE_ID_CANCEL_SUBSCRIPTION = 58;
    public static final int SERVICE_ID_B_FILE_RECONCILE = 59;
    public static final int SERVICE_ID_PANIC_WITHDRAWAL = 60;
    public static final int SERVICE_ID_ORDER_SUSPEND = 61;
    public static final int SERVICE_ID_INTL_CORPORATE_ACTION = 63;
    public static final int SERVICE_ID_PANIC_WITHDRAWAL_APPROVAL = 65;
    public static final int SERVICE_ID_APPROVE_ORDER = 66;
    public static final int SERVICE_ID_REJECT_ORDER = 67;
    public static final int SERVICE_ID_CANCEL_ALL_CHILD_ORDERS = 70;
    public static final int SERVICE_ID_APPROVE_PLEDGE_BULK = 71;
    public static final int SERVICE_ID_TRADE_PROCESSING = 73;
    public static final int SERVICE_ID_TRADE_PROCESSING_APPROVE = 74;
    public static final int SERVICE_ID_CASH_TXN_APPROVE = 301;
    public static final int SERVICE_ID_CASH_TXN_REJECT = 302;
    public static final int SERVICE_ID_PRE_TRADE_ALLOCATION = 303;
    public static final int SERVICE_ID_POST_TRADE_ALLOCATION = 304;

    public static final int SERVICE_ID_PULSE = 0;

    // =============================== Internal Service IDS =============================
    public static final int SERVICE_ID_GENERAL_ACKNOWLEDGEMENT = 1000;
    public static final int SERVICE_ID_LIST_CACHE_NAMES = 1001;
    public static final int SERVICE_ID_CACHE_REMOVE_BY_ID = 1002;
    public static final int SERVICE_ID_CACHE_SEARCH_BY_ID = 1003;
    public static final int SERVICE_ID_CACHE_SEARCH_ALL = 1004;
    public static final int SERVICE_ID_CACHE_REMOVE_ALL = 1005;
    public static final int SERVICE_ID_ORDER_RECONCILIATION_DEV_INIT = 1006; // these services are implemented for developer testings
    public static final int SERVICE_ID_ORDER_RECONCILIATION_DEV_EXECUTE = 1007;// these services are implemented for developer testings
    public static final int SERVICE_ID_UPDATE_CACHE_ENTRY = 1008;
    public static final int SERVICE_ID_LOAD_CACHE_ENTRY_FROM_DB = 1009;
    public static final int SERVICE_ID_AUTHENTICATE_USER = 1010;
    public static final int SERVICE_ID_AUDIT_UPDATES = 1011;
    public static final int SERVICE_ID_MEM_MAP_INQUIRY = 1012;
    // =============================== Internal Service IDS END =============================

    public static final int ORDER_INCOMPLETE_SETTLEMENT_DATE_NULL = 1;
    public static final int ORDER_INCOMPLETE_EXECUTION_MISSING = 2;
    public static final int ORDER_INCOMPLETE_OUT_OF_ORDER_EXEC = 3;

    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_FAIL = -1;
    public static final String SUCCESS_NARRATION = "Success";
    public static final String FAIL_NARRATION = "Failed";

    //================================== Bean Names ======================================
    public static final String BEAN_NAME_OMS_CUSTOMISED_BEAN_LOADER = "customBeanLoader";
    //================================== Bean Names END===================================


    public static final String APP_MON_APPLICATION_NAME = "OMS";
    public static final int SYSTEM_USER_ID = 0;

    //0 - Pending, 1 - Active(Valid), 2 - Locked, 3 - Suspended, -1 -Invalid
    public static final int LOGIN_STATUS_INVALID = -1;
    public static final int LOGIN_STATUS_PENDING = 0;
    public static final int LOGIN_STATUS_ACTIVE = 1;
    public static final int LOGIN_STATUS_LOCKED = 2;
    public static final int LOGIN_STATUS_SUSPENDED = 3;

    public static final int LOGGED_STATUS_SUCCESS = 1;
    public static final int LOGGED_STATUS_FAILED = -1;

    public static final int SESSION_STATUS_VALID = 1;
    public static final int SESSION_STATUS_IN_VALID = 2;
    public static final int SESSION_STATUS_CHANGE_PW_REQUIRED = 3;
    public static final int SESSION_STATUS_OTP_VALIDATION_REQUIRED = 4;
    public static final int SESSION_STATUS_OTP_VALIDATED = 5; //i.e otp validation success with db/cache

    public static final int NORMAL_AUTH_LOGIN_TYPE = 1;
    public static final int OTP_REQUIRED_AUTH_LOGIN_TYPE = 2;

    public static final String SYMBOL_KEY_SEPARATOR = "~";
    public static final String IP_PORT_SEPARATOR = ":";
    public static final String TIME_SEPARATOR = ":";
    public static final String COMMA_SEPARATOR = ",";
    public static final String FIELD_SEPARATOR = ";";
    public static final String PIPE_SEPARATOR = "|";
    public static final String CUSTOM_KEY_SEPARATOR = "#";
    public static final String HISTORY_PWD_SEPARATOR = " ";

    public static final String MSG_PARAM = "#VAL";

    public static final int ORDER_SIDE_BUY = 1;
    public static final int ORDER_SIDE_SELL = 2;
    public static final int ORDER_SIDE_SUBSCRIPTION = 3; // need to refactor as 'D'

    public static final String SIDE_BUY = "BUY";
    public static final String SIDE_SELL = "SELL";

    public static final char POSITION_OPEN = 'O';
    public static final char POSITION_CLOSE = 'C';

    public static final int CALL_OPTION = 1;
    public static final int PUT_OPTION = 0;

    public static final int ORDER_TRADE_RESTRICTION_DIRECTION_NONE = 0;
    public static final int ORDER_TRADE_RESTRICTION_DIRECTION_BUY = 1;
    public static final int ORDER_TRADE_RESTRICTION_DIRECTION_SELL = 2;
    public static final int ORDER_TRADE_RESTRICTION_DIRECTION_BOTH = 3;

    public static final int ORDER_TRADE_RESTRICTION_ONLINE_TRADING = 5;

    //commission strategies
    public static final int COMMISSION_TYPE_BY_ORDER_VAL = 0;
    public static final int COMMISSION_TYPE_BY_ORDER_VOLUME = 1;
    public static final int COMMISSION_TYPE_BY_SYMBOL_VOLUME = 2;
    public static final int COMMISSION_TYPE_BY_SHARE_PRICE = 3;
    public static final int COMMISSION_TYPE_BY_EXECUTION = 4;

    public static final int APPROVAL_STATUS_PENDING = 1;
    public static final int APPROVAL_STATUS_APPROVED = 2;
    public static final int APPROVAL_STATUS_REJECTED = 3;

    public static final int SYMBOL_TRADING_STATUS_READY_TO_TRADE = 17;

    //order Action Types
    public static final int ORDER_ACTION_NEW = 1;
    public static final int ORDER_ACTION_CHANGE = 2;
    public static final int ORDER_ACTION_CANCEL = 3;
    public static final int ORDER_ACTION_EXECUTION = 4;
    public static final int ORDER_ACTION_EXPIRE = 5;
    public static final int ORDER_ACTION_ORDER_REVERSE = 6;
    public static final int ORDER_ACTION_MANUAL_ORDER_EXECUTION = 7;
    public static final int ORDER_ACTION_EXECUTION_REVERSE = 8;
    //    public static final int ORDER_ACTION_EXECUTION_MANUAL = 9;
    public static final int ORDER_ACTION_REJECT = 10;
    public static final int ORDER_ACTION_RESEND = 11;
    public static final int ORDER_ACTION_SUBSCRIPTION_APPROVE = 12;
    public static final int ORDER_ACTION_SUBSCRIPTION_REJECT = 13;
    public static final int ORDER_ACTION_SUSPEND = 14;
    public static final int ORDER_ACTION_TRADE_PROCESSING = 15;
    public static final int ORDER_ACTION_APPROVE = 16;
    public static final int ORDER_ACTION_CANCEL_ALL_CHILD_ORDERS = 17;


    public static final int ORDER_STATUS_VALID = 1;
    public static final int ORDER_STATUS_INVALID = -1;

    public static final int DEALER_ENT_NEW_ORDER = 1156;
    public static final int DEALER_ENT_AMEND_ORDER = 1157;
    public static final int DEALER_ENT_CANCEL_ORDER = 1158;

    int EMP_TYPE_DEALER = 3;
    int EMP_TYPE_BRANCH_DEALER = 4;

    int PROCESS_TYPE_BULK = 1;

    public static final int ORDER_MODE_OFFLINE = 1;
    public static final int ORDER_MODE_NORMAL = 0;

    public static final int CHANNEL_EXTERNAL = 0;
    public static final int CHANNEL_WEB = 1;
    public static final int CHANNEL_MPRO = 2;
    public static final int CHANNEL_MANUAL = 4;
    public static final int CHANNEL_FIX = 5;
    public static final int CHANNEL_TWS = 6;
    public static final int CHANNEL_AT = 7;
    public static final int CHANNEL_MOBILE = 9;
    public static final int CHANNEL_IVR = 10;
    public static final int CHANNEL_APPLET = 11;
    public static final int CHANNEL_DT = 12;
    public static final int CHANNEL_PRO = 14;
    public static final int CHANNEL_IPHONE = 16;
    public static final int CHANNEL_IPAD = 17;
    public static final int CHANNEL_B2B = 20;
    public static final int CHANNEL_SYSTEM = 21;

    public static final String FIX_VER_42 = "FIX.4.2";


    public static final int NUMBER_100000 = 100000;
    public static final int NUMBER_100 = 100;
    public static final int NUMBER_0 = 0;
    public static final int NUMBER_1 = 1;
    public static final int NUMBER_2 = 2;
    public static final int NUMBER_3 = 3;
    public static final int NUMBER_4 = 4;
    public static final int NUMBER_5 = 5;
    public static final int NUMBER_MINUS_1 = -1;
    public static final String STRING_1 = "1";
    public static final String STRING_2 = "2";
    public static final String STRING_3 = "3";
    public static final String STRING_4 = "4";
    public static final String STRING_MINUS_1 = "-1";
    public static final String STRING_MINUS_2 = "-2";
    public static final String STRING_TRUE = "TRUE";
    public static final String STRING_FALSE = "FALSE";
    public static final String MURABAHA_STOCK_MOVEMENT = "M";
    public static final char CHAR_DEFAULT = '\u0000';


    public static final String FD = "\u0001";
    public static final String FS = "\u001C";
    public static final String DS = "\u0002";
    public static final String RS = "\u001E";
    public static final String TS = "\u0019";
    public static final String OP = "\u000F";

    public static final byte DISPLAY_LATEST_TRUE = (byte) 1;
    public static final byte DISPLAY_LATEST_FALSE = (byte) 0;


    public static final int POSITIVE_SIGN = 1;
    public static final int NEGATIVE_SIGN = -1;
    public static final String YES = "Y";

    public static final String APPIA_MSG_DATA_FORMAT_RAW_DATA = "0";
    public static final String APPIA_PROTOCOL_FIX = "FIX";

    public static final String CHARSET_ISO_8859_1 = "ISO-8859-1";
    public static final String CHARSET_WINDOWS_1256 = "windows-1256";

    public static final int ROUNDING_PRECESSION_DEFAULT = 8;

    public static final String DEFAULT_TENANCY_CODE = "DEFAULT_TENANT";
    public static final String OMS_INDEX = "OMS_INDEX";

    public static final char ORDER_STATUS_DEFAULT = 'X';
    public static final char ORDER_STATUS_FAILED = 'R';
    public static final String ORDER_REJECT_REASON_ROLL_BACK = "ROLL_BACK";

    public static final char ORDER_MSG_TYPE_D = 'D';
    public static final char ORDER_MSG_TYPE_G = 'G';
    public static final char ORDER_MSG_TYPE_F = 'F';

    public static final String APP_PARAM_MULTI_TENANCY_ALLOWED = "MultiTenancyAllowed";
    public static final String APP_PARAM_IS_PROD = "IS_PROD";
    public static final String APP_PARAM_IS_PARALLEL_RUN = "IS_PARALLEL_RUN";
    public static final String APP_PARAM_IS_CUSTOM = "IS_RUNTIME_CUSTOM";
    public static final String APP_PARAM_IS_STP_ENABLED_CLIENT = "IS_STP_ENABLE_CLIENT_PROD";
    public static final String APP_PARAM_IS_B2B_ENABLED = "B2B_ENABLED";
    public static final String APP_PARAM_IS_OVERDRAW_ALLOWED = "OVERDRAW_ALLOWED";
    public static final String APP_PARAM_RECOVERY_PERSIST_METHOD = "RECOVERY_PERSIST_METHOD"; //i.e. 0:Default,XA-Container Manged,1: NONE_XA-Using Future and Concurrent,2:NONE_XA-Using Future and Sequential
    public static final String APP_PARAM_IS_RECOVERY_DISABLED = "CASSANDRA_DISABLED"; //i.e. enable/disable cassandra/oracle audit async call
    public static final String APP_PARAM_SYMBOL_CLEAR_PERIOD = "SYMBOL_CLEAR_PERIOD";   //time in milliseconds

    public static final String APP_PARAM_EOD_RECONCILIATION_TIMER = "EOD_RECONCILIATION_SCHEDULE_TIME"; //EOD reconciliation scheduled timer
    public static final String APP_PARAM_EOD_CACHE_CLEAR_TIMER = "EOD_OMS_CACHE_CLEAR_SCHEDULE_TIME"; //EOD oms cache clear scheduled timer
    public static final String APP_PARAM_DECIMAL_FORMATTER = "ENABLE_DECIMAL_FORMATTING";
    public static final String APP_PARAM_BOOT_STRAP_STATUS = "BOOT_STRAP_STATUS";

    public static final String APP_PARAM_EOD_JOB_PROCESS_START_TIMER = "EOD_JOB_PROCESS_START_TIMER"; //EOD job process start timer
    public static final String APP_PARAM_EOD_JOB_PROCESS_END_TIMER = "EOD_JOB_PROCESS_END_TIMER"; //EOD job process end timer

    public static final String APP_PARAM_DEFAULT_SESSION_DURATION = "DEFAULT_SESSION_DURATION";
    public static final String APP_PARAM_PRO_VERSION = "PRO_VERSION";
    public static final String APP_PARAM_DT_AUTO_UPDATE_SUPPORT = "DT_AUTO_UPDATE_SUPPORT";
    public static final String APP_PARAM_REPORT_DEPTH = "REPORT_DEPTH";
    public static final String APP_PARAM_URL_REPORTS = "URL_REPORTS";
    public static final String APP_PARAM_MAX_PASSWORD_ATTEMPTS = "MAX_PASSWORD_ATTEMPTS";
    public static final String APP_PARAM_OTP_EXPIRATION_PERIOD = "OTP_EXPIRATION_PERIOD";
    public static final String APP_PARAM_CLIENT_VERSION = "VER_CLIENT";

    public static final String SYS_PROPERTY_APP_SERVER_ID = "APP_SERVER_ID";
    public static final String SYS_PROPERTY_APP_SERVER_IP = "APP_SERVER_IP";
    public static final String SYS_PROPERTY_APP_SERVER_PORT = "APP_SERVER_PORT";
    public static final String SYS_PROPERTY_MAX_CLORDID_LENGTH = "MAX_CLORDID_LENGTH";
    public static final String SYS_PROPERTY_CASSANDRA_DB_URL = "CASSANDRA_DB_URL";
    public static final String SYS_PROPERTY_EXECUTOR_SERVICES_WATCHDOG = "EXECUTOR_SERVICES_JNDI_WATCHDOG";
    public static final String SYS_PROPERTY_EXECUTOR_SERVICES_PERSIST = "EXECUTOR_SERVICES_JNDI_PERSIST";
    public static final String SYS_PROPERTY_EXECUTOR_SERVICES_ORDER_PUSH = "EXECUTOR_SERVICES_JNDI_ORDER_PUSH";
    public static final String SYS_PROPERTY_EXECUTOR_SERVICES_OMS_COMMON = "EXECUTOR_SERVICES_JNDI_OMS_COMMON";
    public static final String SYS_PROPERTY_EXECUTOR_SERVICES_AUTH_HANDLERS = "EXECUTOR_SERVICES_AUTH_HANDLERS";
    public static final String SYS_PROPERTY_KAFCA_SERVERS = "KAFCA_SERVERS"; //e.x. localhost:9063,localhost:9064
    public static final String SYS_PROPERTY_KAFCA_BATCH_SIZE = "KAFCA_BATCH_SIZE"; //e.x. localhost:9063,localhost:9064
    public static final String SYS_PROPERTY_ORDER_CACHE_CLEAR_TIMEOUT_SECS = "ORDER_CACHE_CLEAR_TIMEOUT_SECS";
    public static final String SYS_PROPERTY_ENABLE_WATCH_DOG = "WATCH_DOG_AGENT_ENABLE";
    public static final String SYS_PROPERTY_FALCON_IP = "FALCON_IP";
    public static final String SYS_PROPERTY_FALCON_PORT = "FALCON_PORT";
    public static final String SYS_PROPERTY_RECOVERY_PERSIST_TIMEOUT = "RECOVERY_PERSIST_TIMEOUT_IN_SECONDS";
    public static final String SYS_PROPERTY_KAFACA_ENABLED = "ENABLE_KAFCA";
    public static final String SYS_PROPERTY_DEFAULT_AUTO_USER = "DEFAULT_AUTO_USER";
    public static final String SYS_PROPERTY_TENANT_LIST = "TENANTS";
    public static final String SYS_PROPERTY_PRICE_SUBSCRIBE_EXCHANGES = "PRICE_SUBSCRIBE_EXCHANGES";
    public static final String SYS_PROPERTY_PRICE_SUBSCRIBE_URL = "PRICE_SUBSCRIBE_URL";
    public static final String SYS_PROPERTY_PRICE_SUBSCRIBE_URL_PARAMS = "PRICE_SUBSCRIBE_URL_PARAM";
    public static final String SYS_PROPERTY_PRICE_SUBSCRIBE_CACHE_CLEAR_DELAY_MILLIS = "PRICE_SUBSCRIBE_CACHE_CLEAR_DELAY_MILLIS";
    public static final String SYS_PROPERTY_ALLOW_MULTI_TENANT = "ALLOW_MULTI_TENANT";
    public static final String SYS_PROPERTY_OMS_INDEX_PRELOAD = "OMS_INDEX_PRELOAD"; //index_preload
    public static final String SYS_PROPERTY_JMS_TTL = "JMS_TTL_IN_MILLIS"; //JMS time to live

    public static final int APP_SERVER_ID_LENGTH = 1;
    public static final int CLIORDID_DAY_YEAR_SECTION_LENGTH = 3;
    public static final int CLIORDID_TIME_SECTION_LENGTH = 6;
    public static final int CLIORDID_COUNTER_SECTION_LENGTH = 4;
    public static final int DEFAULT_CLORDID_SYSTYM_LENGTH = 15;
    public static final int DEFAULT_ORDER_CACHE_CLEAR_TIMEOUT_SECS = 60;
    public static final int DEFAULT_RECOVERY_PERSIST_TIMEOUT_SECS = 15;

    public static final String JMS_MSG_PROPERTY_CLIENT_MSG_ID = "ClientMsgID";
    public static final String JMS_MSG_PROPERTY_SESSION_ID = "SessionID";
    public static final String JMS_MSG_PROPERTY_PROTOCOL = "Protocol";
    public static final String JMS_MSG_PROPERTY_FORMAT = "Format";
    public static final String JMS_MSG_PROPERTY_MSG_TYPE = "MessageType";
    public static final String JMS_MSG_PROPERTY_EVENT_TYPE = "EventType";
    public static final String JMS_MSG_PROPERTY_EVENT_DATA = "EventData";
    public static final String JMS_MSG_PROPERTY_MSG_DATA = "MessageData";
    public static final String JMS_MSG_PROPERTY_SEQ_NO = "SequenceNo";
    public static final String JMS_MSG_PROPERTY_META_DATA = "META_DATA";

    //========================== JMS Group Settings =======================

    public static final String JMS_GRP_DEFAULT_GROUP = "DEFAULT_GRP";
    public static final String JMS_GRP_EXCHANGE_MESSAGE_UUID_NAME = "OrigExchangeMessageUUID";
    public static final String JMS_GRP_ID_PROPERTY = "JMSXGroupID";
    public static final String SYS_PROPERTY_JMS_SESSION_COUNT = "JMS_SESSION_COUNT";
    public static final String SYS_PROPERTY_JMS_GRP_EXCHANGE_LVL_GROUPING = "EXCHANGE_LEVEL_GROUPING";
    public static final String JMS_GRP_EXCHANGE_LVL_GROUPING_ENABLED = "TRUE";


    public static final String KAFCA_MSG_CLUSTER_KEY_ORDER = "OMS_ORDER_PUSH";
    public static final String KAFCA_MSG_DESTINATION_ORDER_EXECUTION = "order-executions";

    public static final int ACCESS_LEVEL_LOCAL = 1;
    public static final int ACCESS_LEVEL_GCC = 2;
    public static final int ACCESS_LEVEL_INTERNATIONAL = 3;

    public static final int FIX_CUSTOM_TENANT_ID = 7999;
    public static final int KAFCA_PRODUCER_MSG_SIZE_DEFAULT = 100;

    public static final String MEM_MAP_FILE_FOLDER = "MAP_FILES/";
    public static final String MEM_MAP_AUDIT_FILE_NAME = "MemoryMapAudit";
    public static final String MEM_MAP_META_DATA_FILE_NAME = "MemoryMapMetaData";
    public static final String MEM_MAP_PREOPEN_FILE_NAME = "MemoryMapPreOpen";

    public static final String SYMBOL_SECURITY_STATUS = "SYMBOL SECURITY STATUS";
    public static final String TRADING_SESSION_STATUS = "TRADING SESSION STATUS";

    int TRADING_MARKET_TYPE_TRADE = 1;
    int TRADING_ACCNT_TYPE_FULL_DISCLOSED = 1;
    int TRADING_ACCNT_TYPE_NON_DISCLOSED = 2;

    int CUSTOMER_ACCNT_TYPE_MASTER = 1;
    int CUSTOMER_ACCNT_TYPE_SUB = 2;

    public static final String EXCHANGE_DGCX = "DGCX";

    public static final int SESSION_STATUS_CONNECTED = 1;
    public static final int SESSION_STATUS_DISCONNECTED = 0;

    public static final String LOG_TXT_EXEC_ID = ",ExecID:";
    public static final String LOG_TXT_EXEC = "EXEC:";
    public static final String LOG_TXT_REQ_ID = ",REQ_ID:";

    public static final String TRD_MKT_PROCESS_PRE_OPEN = "PRE_OPEN_RUNNING";
    public static final String TRD_MKT_PROCESS_EOD = "EOD_RUNNING";
    public static final String TRD_MKT_NO_PROCESS = "NONE";

    //	Order execution category
    public static final int ORD_EXEC_NORMAL = 1;
    public static final int ORD_EXEC_ALGO = 4;
    public static final int ORD_EXEC_COND = 2;
    int ORD_EXEC_DESK = 5;
    int ORD_EXEC_TRADE_PROCESSING = 6;


    // =============================== Oms cacheMonitor constants =============================
    public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
    public static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
    public static final String ACCESS_UNAUTHORIZED = "Token Expired";
    public static final String ACCESS_FORBIDDEN = "Unauthorized Login";


    //========================== Cash and Holding Transfer Constants ===================
    public static final String CASH_DEPOSIT = "DEPOST";
    public static final String CASH_WITHDRAW = "WITHDR";
    public static final String CASH_TRANSFER = "CSHTRN";
    public static final String CHARGE_CODE = "CHARGE";
    public static final String REFUND_CODE = "REFUND";


    public static final int CASH_TRN_CHARGE = 1;
    public static final int CASH_TRN_REFUND = 2;

    public static final String CACHE_MON_KEY = "secret";

    public static final String OMS_KEY_SPACE = "OMSKS_V2";
    public static final String SHARE_TRANSFER_FEE_CODE = "STPFEE";


    //========================== Cash Holding Restriction types =======================
    public static final int CASH_DEPOSIT_RESTRICTED = 9;
    public static final int CASH_WITHDRAW_RESTRICTED = 10;
    public static final int CASH_TRANSFER_RESTRICTED = 11;
    public static final int CASH_DISABLED_ONLINE = 12;
    public static final int CASH_DISABLED_ONLINE_OFFLINE = 13;
    public static final int BENEFICIARY_TRN_CASH_ACC = 1;
    public static final int BENEFICIARY_TRN_BANK_ACC = 2;

    public static final int SHARE_DEPOSIT = 1;
    public static final int SHARE_WITHDRAW = 2;
    public static final int SHARE_TRANSFER = 7;

    public static final int PLEDGE_IN = 8;
    public static final int PLEDGE_OUT = 9;

    public static final int SHARE_RESTRICTION_BOTH = 3;
    public static final int SHARE_RESTRICTION_DEPOSIT = 6;
    public static final int SHARE_RESTRICTION_WITHDRAW = 7;
    public static final int SHARE_RESTRICTION_TRANSFER = 8;

    //========================= Payment Methods =========================================
    public static final int PAYMENT_METHOD_CASH = 1;
    public static final int PAYMENT_METHOD_CHECK = 2;
    public static final int PAYMENT_METHOD_TRANSFER = 3;

    public static final String SECURITY_ID_SOURCE_EXCHANGE_SYMBOL = "8";
    public static final String SECURITY_ID_SOURCE_ISIN_CODE = "4";
    public static final String SECURITY_ID_SOURCE_RIC_CODE = "5";
    public static final String SECURITY_ID_SOURCE_DEFAULT = "0";

    public static final String SECURITY_EXCHANGE_TDWL = "TDWL";
    public static final String SECURITY_EXCHANGE_KSE = "KSE";

    public static final int MARGIN_DISABLED = 0;
    public static final int MARGIN_ENABLED = 1;
    public static final int MARGIN_EXPIRED = 2;

    //========================= EOD Reconciliation =========================================
    public static final int EOD_FILE_UPLOAD_REVERSE_ORDER = 1;
    public static final int EOD_PROCESS_STATUS_START = 0;
    public static final int EOD_PROCESS_STATUS_DB_COMPARISON_RUNNING = 1;
    public static final int EOD_PROCESS_STATUS_DB_COMPARISON_COMPLETED = 2;
    public static final int EOD_PROCESS_STATUS_FILE_UPLOAD_RUNNING = 3;
    public static final int EOD_PROCESS_STATUS_FILE_UPLOAD_COMPLETED = 4;
    public static final int EOD_PROCESS_STATUS_DB_SYNC_RUNNING = 5;
    public static final int EOD_PROCESS_STATUS_DB_SYNC_COMPLETED = 6;
    public static final int EOD_PROCESS_STATUS_COMPLETED = 7;

    public static final int CA_RECONCILATION = 1;
    public static final int WEEKLY_RECONCILATION = 2;
    public static final int BFILE_RECONCILIATION = 3;
    public static final int INTL_CA_RECONCILATION = 4;


    public static final String LAST_SYMBOL_CACHE_CLEAR_TIME = "SYMBOL_CLR_TIME";
    public static final String EOD_LAST_RAN_DATE = "EOD_DATE";
    public static final String EOD_CACHE_CLEAR_LAST_RAN_DATE = "EOD_CACHE_CLEAR_DATE";
    public static final String EOD_CACHE_CLEAR_NOT_RUN = "NOT_RUN";
    public static final String PRICE_SUB_LAST_RAN_DATE = "PRICE_SUB_INIT_DATE";
    public static final String PRICE_SUB_LAST_INVOKE = "PRICE_SUB_LAST_INVOKE";

    //========================= Reconcile Properties ===================================
    public static final String RECON_PROPERTY_FIX_LOG_URL = "FIX_LOG_URL";


    public static final String AUDIT_KEY_PREFIX_ORDER = "ORD";
    public static final String AUDIT_KEY_PREFIX_DESK_ORDER = "DSK";
    public static final String AUDIT_KEY_PREFIX_ALGO_ORDER = "ALG";
    public static final String AUDIT_KEY_PREFIX_CONDITIONAL_ORDER = "CON";
    public static final String AUDIT_KEY_PREFIX_CASH_TRANSFER = "CSH";
    public static final String AUDIT_KEY_PREFIX_DEFAULT = "DFT";

    public static final int OMSV_WAITING_FOR_APPROVE_OR_CONFIRMATION = 1;
    public static final int WFA_TYPE_EXCEED_MAX_ORDER_LIMIT = 3;
    public static final int OMSV_WAITING_FOR_APPROVE_REJECT = 4;
    public static final int WFA_INSUFFICIENT_BUYING_POWER = 5;

    public static final int CASH_APPROVE_STATUS_CANCEL = 3;
    public static final String AUDIT_KEY_PREFIX_SHARE_TRANSFER = "SHT";
    public static final String AUDIT_KEY_PREFIX_PLEDGE_TXN = "PLG";
    public static final int SYMBOL_RESTRICTION = 1;
    public static final int TRADING_PREVILEGES = 2;
    public static final int POA_SYMBOL_RESTRICTION = 1;

    // Custodian Trade Rejection
    public static final int ICM_REJECT = 1;
    public static final int ICM_SETTLE = 2;
    public static final int ICM_BUY_IN = 3;
    public static final int ICM_FAIL_CHAIN = 4;
    public static final int RECAPTURE_ICM_REJECT = 5;

    public static final int CUSTODY_TYPE_NONE = 0;   //both cash and holdings are validated by OMS
    public static final int CUSTODY_TYPE_FULL_CUSTODY = 1;   //both cash and holdings are not validated by OMS
    public static final int CUSTODY_TYPE_VALIDATE_CASH_ONLY = 2;    //cash is validated by OMS
    public static final int CUSTODY_TYPE_VALIDATE_HOLDING_ONLY = 3;     //holding is valiadted by OMS

    public static final String APP_PARAM_IS_COMMISION_OVERWIRE_ENABLED = "COMM_OVERWRITE_ENABLED";
    public static final int WFA_COMMISSION_OVERWRITE = 6;
    public static final int WFA_LIQUIDATION = 6;

    //========================== Notification Subjects types ======================= This Should be synchronize with m148
    public static final int CASH_DEPOSIT_NOTIFICATION = 19;
    public static final int CASH_WITHDRAW_NOTIFICATION = 42;

    public static final int ORDER_ACCEPT_NOTIFICATION = 16;
    public static final int ORDER_QUEUED_NOTIFICATION = 17;
    public static final int ORDER_EXECUTION_NOTIFICATION = 18;
    public static final int ORDER_REJECT_NOTIFICATION = 22;
    public static final int ORDER_CANCELLED_NOTIFICATION = 26;
    public static final int ORDER_PARTIALLY_FILLED_NOTIFICATION = 23;
    public static final int ORDER_AMEND_NOTIFICATION = 28;

    public static final int CUSTOMER_LOGIN_NOTIFICATION = 37;
    public static final int CUSTOMER_CREATION_NOTIFICATION = 32;
    public static final int SHARE_TRANSFER_NOTIFICATION = 29;
    //========================== Ends Notification Subjects types ======================= This Should be synchronize with m148

    //Audit Activity Ids - a06_audit
    public static final int AUDIT_ID_CASH_DEPOSIT = 3006013;    //(tableId + 0 + m82_id)
    public static final int AUDIT_ID_CASH_WITHDRAW = 3006014;
    public static final int AUDIT_ID_CASH_TRANSFER = 3006015;
    public static final int AUDIT_ID_CASH_CHARGE = 3006016;
    public static final int AUDIT_ID_CASH_REFUND = 3006017;
    public static final int AUDIT_ID_SHARE_DEPOSIT = 3012013;
    public static final int AUDIT_ID_SHARE_WITHDRAW = 3012014;
    public static final int AUDIT_ID_SHARE_TRANSFER = 3012015;
    //========================== Language types =======================

    public static final String ENGLISH_LANG = "EN";

    public static final String SECONDARY_LANG = "AR";

    public static final int PRICE_SBCRPTN_AUTH_STATUS_SUCCESS = 1;
    public static final int PRICE_SBCRPTN_AUTH_STATUS_FAIL = -1;
    public static final int PRICE_SBCRPTN_AUTH_STATUS_PENDING = 0;

    public static final String PRICE_SBCRPTN_SSL_CONTEXT = "io.undertow.websocket.SSL_CONTEXT";
    public static final String PRICE_SBCRPTN_REQ_EQUITY = "0";
    public static final String PRICE_SBCRPTN_REQ_LOGIN = "10";
    public static final String PRICE_SBCRPTN_REQ_FULL_MKT = "0";
    /*--Response Constants---*/
    public static final int PRICE_SBCRPTN_RES_EQUITY_UPDATE = 3;
    public static final int PRICE_SBCRPTN_RES_LOGIN = 150;

    public static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HTTP_HEADER_METHOD_TYPE_POST = "POST";
    public static final String HTTP_HEADER_CONTENT_TYPE_JSON = "application/json";


    public static final int PRICE_BLK_TYPE_DEFAULT = 0;
    public static final int PRICE_BLK_TYPE_MAX = 1;
    public static final int PRICE_BLK_TYPE_BEST_BID = 2;
    public static final int PRICE_BLK_TYPE_BEST_ASK = 3;
    public static final int PRICE_BLK_TYPE_LAST_TRADE = 4;


    public static final int FAILED_TRADE_REMOVE_FROM_SETTLEMENT = 101;
    public static final int TRADE = 700;
    public static final int FAILED_TRADE_SETTLED = 47;
    public static final int SELL_TRANSACTION = 10;

    public static final int TRO_CONVERSION = 14;
    public static final int TRO_UNSUBSCRIBE = 15;

    public static final int TRANS_SUB_CODE_19 = 19;
    public static final int TRANS_SUB_CODE_4 = 4;
    public static final int TRANS_SUB_CODE_172 = 172;


    public static final String TRANS_CODE_500 = "500";
    public static final String TRANS_CODE_930 = "930";
    public static final String TRANS_CODE_100 = "100";
    public static final String TRANS_CODE_350 = "350";


    public static final int DEFAULT_SESSION_DURATION = 3600;


    public static final int TP_PENDING_APPROVE = 21;
    public static final int TP_PENDING_SETTLE = 24;
    public static final int TP_SETTLED = 25;


    public static final int PARAM_0 = 0;
    public static final int PARAM_1 = 1;
    public static final int PARAM_2 = 2;
    public static final int PARAM_3 = 3;
    public static final int PARAM_4 = 4;
    public static final int PARAM_5 = 5;
    public static final int PARAM_6 = 6;
    public static final int PARAM_7 = 7;
    public static final int PARAM_8 = 8;
    public static final int PARAM_9 = 9;
    public static final int PARAM_10 = 10;
    public static final int PARAM_11 = 11;
    public static final int PARAM_12 = 12;
    public static final int PARAM_13 = 13;
    public static final int PARAM_14 = 14;
    public static final int PARAM_15 = 15;
    public static final int PARAM_16 = 16;
    public static final int PARAM_17 = 17;
    public static final int PARAM_18 = 18;
    public static final int PARAM_19 = 19;
    public static final int PARAM_20 = 20;
    public static final int PARAM_21 = 21;
    public static final int PARAM_22 = 22;
    public static final int PARAM_23 = 23;
    public static final int PARAM_24 = 24;
    public static final int PARAM_25 = 25;
    public static final int PARAM_26 = 26;
    public static final int PARAM_27 = 27;
    public static final int PARAM_28 = 28;
    public static final int PARAM_29 = 29;
    public static final int PARAM_30 = 30;
    public static final int PARAM_31 = 31;
    public static final int PARAM_32 = 32;
    public static final int PARAM_33 = 33;
    public static final int PARAM_34 = 34;
    public static final int PARAM_35 = 35;
    public static final int PARAM_36 = 36;
    public static final int PARAM_37 = 37;
    public static final int PARAM_38 = 38;
    public static final int PARAM_39 = 39;
    public static final int PARAM_40 = 40;
    public static final int TAX_BY_BROKER_COMMISSION = PARAM_7;
    public static final int TAX_WAIVE_OFF = PARAM_1;

    int ORDER_CATEGORY_NORMAL = PARAM_1;
    int ORDER_CATEGORY_OFFLINE = PARAM_2;
    int ORDER_CATEGORY_CONDITIONAL = PARAM_3;
    int ORDER_CATEGORY_ALGO = PARAM_4;
    int ORDER_CATEGORY_DESK = PARAM_5;
    int ORDER_CATEGORY_CHILD = PARAM_6;
    int ORDER_CATEGORY_ADVANCE = PARAM_7;
    int ORDER_CATEGORY_TRADE_CONDITIONAL = PARAM_8;

    public static final int T09_UPDATE_IMPACT_TYPE_ORDER = 1;
    public static final int T09_UPDATE_IMPACT_TYPE_CASH_ONLY = 2;
    public static final int T09_UPDATE_IMPACT_TYPE_HOLDING_ONLY = 3;
    public static final int T09_UPDATE_IMPACT_TYPE_CASH_ONLY_WITHOUT_T02 = 6;
    public static final int T09_UPDATE_IMPACT_TYPE_HOLDING_ONLY_WITHOUT_T02 = 7;


    public static final int RULE_STATUS_NEW = 0;
    public static final int RULE_STATUS_PENDING = 1;  //'D'
    public static final int RULE_STATUS_REJECTED = 2;
    public static final int RULE_STATUS_TRIGGERED = 3;
    public static final int RULE_STATUS_EXPIREDG = 4;
    public static final char RULE_STATUS_CANCELLED = 5;
    public static final int RULE_STATUS_AMENDED = 6;
    public static final int RULE_STATUS_DONE = 7;//processing done for slice order
    public static final int RULE_STATUS_PAUSED = 8;
    public static final int RULE_STATUS_ACCEPTED = 9;
    public static final int SLICE_THIRD_PARTY_TVOL = 11;
    public static final int SLICE_THIRD_PARTY_TWAP = 12;
    public static final int SLICE_THIRD_PARTY_VWAP = 13;
    public static final int SLICE_HUNT = 10;

    public static final int OPERATOR_EQUAL = 0;
    public static final int OPERATOR_GREATER_THAN_OR_EQ = 1;
    public static final int OPERATOR_LESS_THAN_OR_EQ = 2;
    public static final int OPERATOR_GREATER_THAN = 3;
    public static final int OPERATOR_LESS_THAN = 4;

    public static final int RULE_METHOD_LAST_TRADE = 1;
    public static final int RULE_METHOD_BID = 2;
    public static final int RULE_METHOD_ASK = 3;


    public static final String ALGO_TVOL = "TVOL";
    public static final String ALGO_TWAP = "TWAP";
    public static final String ALGO_VWAP = "VWAP";

    String THIRD_PARTY_MRE_EXCHANGE = "MRE";
    String THIRD_PARTY_MRE_SUB_MARKET = "ALL";

    int STATUS_INVALID = 1;
    //========================== Margin Notification types =======================
    public static final int MARGIN_NOTIFICATION_LEVEL = 1;
    public static final int MARGIN_REMINDER_LEVEL = 2;
    public static final int MARGIN_LIQUIDATION_LEVEL = 3;
    public static final String LIQUIDATION_LAST_RAN_TIME = "LIQ_TIME";
    public static final String APP_PARAM_LIQUIDATION_PERIOD = "LIQ_TIME_PERIOD";
    public static final String APP_PARAM_LIQUIDATION_METHOD = "LIQ_METHOD";

    int USER_TYPE_CUSTOMER = 1;
    int USER_TYPE_EMPLOYEE = 2;

    public static final int PRO_RATA_BASIS = 1;
    public static final int MAX_SYMBOL_MARGIN = 2;

    //======================REMOTE REQUESTS BETWEEN TWO OMS=====================
    int SEND_REMOTE_REQUEST = 1;
    int PROCESS_REMOTE_REQUEST = 2;
    int REMOTE_RESPONSE = 3;

    //====================EJB lookup Strings Map============================
    String EJB_NAMING_MAP = "EJBNamingMap";
    String CLIENT_CONNECTOR_NAMING_MAP = "connectorsFacadeNaming";

    public final int BULK_PLEGE = 1;

    public static final int DEFAULT_MAX_FRACTION = 5;

    public static final String PERSIST_METHOD_XA_CONTAINER = "0";
    public static final String PERSIST_METHOD_NONE_XA_CONCURRENT = "1";
    public static final String PERSIST_METHOD_NONE_XA_NONE_CONCURRENT = "2";

    /* Cash and Holding Transaction
     * Enable 0
     * Dissable = 1
     * */
    public static final int ALLOW_TRANSACTIONS = 0;

    public static final int DUPLICATION_EXEC_TYPE_REPLACED = 1;

    public static final int EOD_JOB_TYPE_PENDING_CASH_EOD = 5;
    public static final int EOD_JOB_TYPE_PENDING_CASH_SOD = 6;
    public static final int EOD_JOB_TYPE_PENDING_HOLDING_EOD = 7;
    public static final int EOD_JOB_TYPE_PENDING_HOLDING_SOD = 8;

}
