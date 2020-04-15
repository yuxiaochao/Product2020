package com.huarui.common;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Constant {

	public static final String SUCCESS = "SUCCESS";

	public static final String FAIL = "FAIL";


	/**
	 * 用户UserID 
	 */
	public static final String SESSION_UserId = "UserID";
	/**
	 * 用户UserID
	 */
	public static final String SESSION_UserAdminLevelOne = "UserAdminLevelOne";
	/**
	 * 用户登录方式
	 */

	public static final String SESSION_UserManagerMode = "UserManagerMode";

	/**
	 * 用户权限
	 */
	public static final String SESSION_UserRightPojo = "UserRightPojo";

	/**
	 * 用户管理的最小父机构ID
	 */

	public static final String SESSION_MinOrganID = "UserManager_MinOrganID";

	/**
	 * 用户名
	 */
	public static final String SESSION_UserName = "UserName";
	/**
	 * 用户姓名
	 */
	public static final String SESSION_UserAlias = "UserAlias";

	/**
	 * 是否是普通用户
	 */
	public static final String SESSION_UserIsCommon = "UserIsCommon";
	/**
	 * 是否是领导
	 */
	public static final String SESSION_UserIsLeader = "UserIsLeader";
	/**
	 * 是否是培训师
	 */
	public static final String SESSION_UserIsTeacher = "UserIsTeacher";
	/**
	 * 是否是管理员
	 */
	public static final String SESSION_UserIsManager = "UserIsManager";
	/**
	 * 是否是联络员
	 */
	public static final String SESSION_UserIsContactor = "UserIsContactor";

	/**
	 * 领导机构管理范围
	 */
	public static final String SESSION_UserLeaderOrganIDs = "UserLeaderIDs";

	/**
	 * 培训师机构管理范围
	 */
	public static final String SESSION_UserTeacherOrganIDs = "UserTeacherIDs";

	/**
	 * 管理员机构管理范围
	 */
	public static final String SESSION_UserManagerOrganIDs = "UserManagerIDs";

	/**
	 * 领导机构管理范围---所能管理的第一个的Level
	 */
	public static final String SESSION_UserLeaderTopLevel = "UserLeaderTopLevel";

	/**
	 * 培训师机构管理范围---所能管理的第一个的Level
	 */
	public static final String SESSION_UserTeacherTopLevel = "UserTeacherTopLevel";

	/**
	 * 培训师机构管理范围---所能管理的第一个的Level
	 */
	public static final String SESSION_UserTeacherFunctions = "UserTeacherFunctions";

	/**
	 * 管理员机构管理范围---所能管理的第一个的Level
	 */
	public static final String SESSION_UserManagerTopLevel = "UserManagerTopLevel";

	/**
	 * 功能模块Map
	 */
	public static final String SESSION_UserRightsMap = "UserRightsMap";

	/**
	 * 是否是管理员
	 */
	public static final String SESSION_IsAdmin = "IsAdmin";
	/**
	 * 用户当前的状态 0：培训师 1：管理员 2：领导
	 */
	public static final String SESSION_UserStatus = "UserStatus";

	/**
	 * 用户管理权限 5：系统管理员 10：机构管理员 15，20:一般管理员
	 */
	public static final String SESSION_UserManagerType = "UserManagerType";

	/**
	 * UserOrganGrade
	 */
	public static final String SESSION_UserOrganGrade = "UserOrganGrade";
	/**
	 * 用户所管理的机构ID字符串
	 */
	public static final String SESSION_Pur_OrgansID = "PurOrgansIDStr";
	/**
	 * 当前登录日志编号WLGID
	 */
	public static final String SESSION_WLGID = "WLGID";
	/**
	 * 当前登录日志编号WLGID
	 */
	public static final String SESSION_SESSIONID = "SESSIONID";
	/**
	 * 当前登录用户机构编号OrganID
	 */
	public static final String SESSION_OrganID = "OrganID";
	/**
	 * 当前登录用户机构名称OrganName
	 */
	public static final String SESSION_OrganName = "OrganName";
	/**
	 * 当前登录用户机构名称OrganLevelName
	 */
	public static final String SESSION_OrganLevelName = "OrganLevelName";
	/**
	 * OrganLevel
	 */
	public static String SESSION_OrganLevel = "aOrganLevel";
	/**
	 * UserType
	 */
	public static final String SESSION_UserType = "UserType";
	/**
	 * UserRole
	 */
	public static final String SESSION_UserRole = "UserRole";

	/**
	 * 用户性别
	 */
	public static final String SESSION_UserSex = "UserSex";

	/**
	 * 当前登录用户参加大型考试PCID(项目编号)
	 */
	public static final String SESSION_PC_PCID = "PCID";

	/**
	 * 当前登录用户参加大型考试PCTyppe(项目类型)
	 */
	public static final String SESSION_PC_PCType = "PCType";

	/**
	 * 当前登录用户参加大型考试ERID(考生编号)
	 */
	public static final String SESSION_PC_ERID = "ERID";

	/**
	 * 当前登录用户参加大型考试BID(批次编号)
	 */
	public static final String SESSION_PC_BID = "BID";

	public static final String SESSION_AuthsList = "authsList";

	/**
	 * 站点名称
	 */
	public static final String Application_AppName = "AppName";
	/**
	 * 根路径
	 */
	public static final String Application_RootDir = "RootDir";
	/**
	 * 站点皮肤风格
	 */
	public static final String Application_ThemeDir = "ThemeDir";
	/**
	 * 网络视频会议地址
	 */
	public static final String Application_MtgServer = "MtgServer";
	/**
	 * 流媒体服务器地址
	 */
	public static final String Application_MediaServer = "MediaServer";
	/**
	 * 非流媒体服务器地址
	 */
	public static final String Application_FileServer = "FileServer";
	
	/**
	 * 3mang服务器地址
	 */
	public static final String Application_liveClassRoomServer = "liveClassRoomServer";
	
	public static final String Application_liveClassRoomServer_WSDL = "liveClassRoomServerWsdl";
	
	/**
	 * 3mang客户端地址
	 */
	public static final String Application_ClientRoomServer = "clientRoomServer";
	
	/**
	 * 3mang客户端端口
	 */
	public static final String Application_ClientRoomPort = "clientRoomPort";
	 
	/**
	 * 3mang站点id
	 */
	public static final String Application_liveClassRoomSiteId = "liveClassRoomSiteId";
	
	/**
	 * 3mang key值
	 */
	public static final String Application_liveClassRoomKey = "liveClassRoomKey";

	/**
	 * web程序部署路径
	 */
	public static final String Application_WebUrl = "WebUrl";
	
	/**
	 * 服务器绝对路径
	 */

	public static final String Application_DiskPath = "DiskPath";
	/**
	 * 登录位置
	 */
	public static final String Application_LoginLocation = "loginLocation";

	/**
	 * 首页位置
	 */
	public static final String Application_IndexLocation = "indexLocation";

	/**
	 * lucene索引路径
	 */
	public static final String Application_LucenePath = "lucenePath";

	/***
	 * 是否启用考试项目
	 */
	public static final String Application_PaperClassExam = "PaperClassExam";

	public static final String Application_PaperClassMap = "PaperClassMap";

	/*
	 * 是否允许用户注册
	 */
	public static final String Application_AllowRegister = "AllowRegister";

	/**
	 * 今年的年份
	 */
	public static final String Application_CurrentYear = "CurrentYear";

	/**
	 * 积分配置 
	 */
	public static final String Application_EnableCreditHour = "EnableCreditHour";
	public static final String Application_cHSettingMap = "cHSettingMap";
	public static ServletContext Global_SC = null;

	public static boolean Globle_ShowSql = false; 
	/**
	 * 是否启用消息队列 
	 */
	public static String Global_JMS = "true";
	/**
	 * 分页时默认每页显示条数
	 */
	public static final int Global_PageSize = 8;
	/**
	 * OrganLevel
	 */
	public static String Global_OrganLevel = "OrganLevel";
	/**
	 * 持久化方式
	 */
	public static String Global_Persistence = "jsp";

	/**
	 * 课程热门度评定标准
	 */
	public static String Application_HotspotLevel = "HotspotLevel";

	/**
	 * 页面标题
	 */
	public static String Global_PageTitle = "PageTitle";
	public static String Global_PageTitleExam = "PageTitleExam";
	public static String Global_SoftName = "SoftName";
	public static String Global_SoftNameExam = "SoftNameExam";
	public static String Global_SoftVersion = "SoftVersion";
	public static String Global_SoftSerialNO = "SoftSerialNO";
	public static String Global_SoftCompany = "SoftCompany";
	public static String Global_SoftCompanyURL = "SoftCompanyURL";
	public static String Global_VersionType = "VersionType";

	public static String Global_IndexLeftTree = "IndexLeftTree";

	public static String Notice_Content = "Notice_Content";
	public static String Notice_BeginDate = "Notice_BeginDate";
	public static String Notice_EndDate = "Notice_EndDate";
	public static String Notice_UserDisplay = "Notice_UserDisplay";
	public static String Notice_LeaderDisplay = "Notice_LeaderDisplay";
	public static String Notice_TeacherDisplay = "Notice_TeacherDisplay";
	public static String Notice_ManagerDisplay = "Notice_ManagerDisplay";

	public static String Config_DBServer_0 = "DBServer_0";
	public static String Config_DBName_0 = "DBName_0";
	public static String Config_DBUser_0 = "DBUser_0";
	public static String Config_DBPassword_0 = "DBPassword_0";
	public static String Config_FtpServer_0 = "FtpServer_0";
	public static String Config_FtpUser_0 = "FtpUser_0";
	public static String Config_FtpPassword_0 = "FtpPassword_0";
	public static String Config_FtpPort_0 = "FtpPort_0";
	public static String Config_ManualParseDA_0 = "ManualParseDA_0";
	public static String Config_Dept_2 = "Dept_2";
	public static String Config_DutyLevel_3 = "DutyLevel_3";
	public static String Config_Duty_2 = "Duty_2";
	public static String Config_Degree_2 = "Degree_2";
	public static String Config_Email_0 = "Email_0";
	public static String Config_EmailServer_0 = "EmailServer_0";
	public static String Config_EmailPort_0 = "EmailPort_0";
	public static String Config_EmailUserName_0 = "EmailUserName_0";
	public static String Config_EmailAddr_0 = "EmailAddr_0";
	public static String Config_EmailPWD_0 = "EmailPWD_0";
	public static String Config_CSoftVersion_0 = "CSoftVersion_0";
	public static String Config_CSoftDescribe_0 = "CSoftDescribe_0";
	public static String Config_DBVersion_0 = "DBVersion_0";
	public static String Config_UserName_3 = "UserName_3";
	public static String Config_UserAlias_3 = "UserAlias_3";
	public static String Config_Sex_3 = "Sex_3";
	public static String Config_PassWord_3 = "PassWord_3";
	public static String Config_Born_3 = "Born_3";
	public static String Config_Mobile_3 = "Mobile_3";
	public static String Config_Tel_3 = "Tel_3";
	public static String Config_EMail_3 = "EMail_3";
	public static String Config_Experience_3 = "Experience_3";
	public static String Config_OrganName_3 = "OrganName_3";
	public static String Config_Department_3 = "Department_3";
	public static String Config_IsLeader_3 = "IsLeader_3";
	public static String Config_UserType_3 = "UserType_3";
	public static String Config_JOB_3 = "JOB_3";
	public static String Config_Duty_3 = "Duty_3";
	public static String Config_IsTeacher_3 = "IsTeacher_3";
	public static String Config_JoinWork_3 = "JoinWork_3";
	public static String Config_JoinDuty_3 = "JoinDuty_3";
	public static String Config_ChargeMsgParam_4 = "ChargeMsgParam_4";
	public static String Config_EmphasisEnable_4 = "EmphasisEnable_4";
	public static String Config_EmphasisType_4 = "EmphasisType_4";
	public static String Config_EmphasisTime_4 = "EmphasisTime_4";
	public static String Config_MsgValidDay_4 = "MsgValidDay_4";
	public static String Config_MsgValidTimeS1_4 = "MsgValidTimeS1_4";
	public static String Config_MsgValidTimeE1_4 = "MsgValidTimeE1_4";
	public static String Config_MsgValidTimeS2_4 = "MsgValidTimeS2_4";
	public static String Config_MsgValidTimeE2_4 = "MsgValidTimeE2_4";
	public static String Config_Section_4 = "Section_4";
	public static String Config_DutyOrgan_3 = "DutyOrgan_3";
	public static String Config_DutyDept_3 = "DutyDept_3";
	public static String Config_DutyUser_3 = "DutyUser_3";
	public static String Config_ChargeMDept_4 = "ChargeMDept_4";
	public static String Config_ExamPaper_1 = "ExamPaper_1";
	public static String Config_OrganLevelName_4 = "OrganLevelName_4";
	public static String Config_ArtDutyName_3 = "ArtDutyName_3";
	public static String Config_ArtDutyOrder_3 = "ArtDutyOrder_3";
	public static String Config_MetierName_3 = "MetierName_3";
	public static String Config_MetierOrder_3 = "MetierOrder_3";

	public static String Config_ADServer_0 = "ADServer_0";
	public static String Config_ADName_0 = "ADName_0";
	public static String Config_ADUser_0 = "ADUser_0";
	public static String Config_ADPassword_0 = "ADPassword_0";

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	public static String Config_NowDateTime = sdf.format(Calendar.getInstance()
			.getTime())
			+ "-01-01";

	/**
	 * 是否启用离线培训功能 Code为 1
	 */
	public static boolean Function_OfflineTrain = false;

	/**
	 * 是否启用在线培训功能 Code为 2
	 */
	public static boolean Function_OnlineTrain = true;

	/**
	 * 是否启用在线学习功能 Code为 3
	 */
	public static boolean Function_OnlineStudy = false;

	/**
	 * 是否启用在线考试功能 Code为 4
	 */
	public static boolean Function_Exam = true;

	/**
	 * 是否启用在线作业功能 Code为 5
	 */
	public static boolean Function_ExamTask = true;

	/**
	 * 是否启用在线练习功能 Code为 6
	 */
	public static boolean Function_ExamTest = true;

	/**
	 * 是否启用自测练习功能 Code为 7
	 */
	public static boolean Function_Exercise = true;

	/**
	 * 是否启用错题中心功能 Code为 8
	 */
	public static boolean Function_FavError = false;

	/**
	 * 是否启用试题收藏功能 Code为 9
	 */
	public static boolean Function_FavCommon = false;

	/**
	 * 是否启用勘误中心功能 Code为 10
	 */
	public static boolean Function_PaperCenter = false;

	/**
	 * 是否启用闯关竞赛功能 Code为 11
	 */
	public static boolean Function_RushGame = true;

	/**
	 * 是否启用在线调查功能 Code为 12
	 */
	public static boolean Function_Research = false;

	/**
	 * 是否启用在线问吧功能 Code为 13
	 */
	public static boolean Function_Ask = false;
	/**
	 * 是否启用培训计划功能 Code为 14
	 */
	public static boolean Function_Plane = false;

	public static final String Application_msgList = "msgList";

	/**
	 * WebService 地址
	 */
	public static String WEBSERVICE_USERNAME = "";
	public static String WEBSERVICE_PASSWORD = "";
	public static String WEBSERVICE_DATATYPE = "";
	public static String WEBSERVICE_URL = "";

	/**
	 * oracle 数据库地址
	 */
	public static String ORCL_USERNAME = "";
	public static String ORCL_PASSWORD = "";
	public static String ORCL_URL = "";

	/**
	 * WEB应用运行模式 0 生产模式 1 开发模式
	 */
	public static final String WEBSERVICE_MODE = "webMode";

	public static final String POSTBAR_FORUMID = "postBarID";

	public static final String AD_EXCEPTION = "adException";

	public static final String LUCENEKEYWORD = "lucenekeyword";

	public static final String ISGBKMEDIAPATH = "isGBKMediaPath";

	/**
	 * 课件服务器地址
	 */
	public static String SESSION_CWServer = "CWSERVER";
	public static String SESSION_CWSMediaServer = "CWSMediaServer";
	public static String SESSION_CWSFileServer = "CWSFileServer";
	public static String SESSION_CWSFlashServer = "CWSFlashServer";

	public static String SESSION_TrainLogMap = "TrainLogMap";
  
	public static String SESSION_LearningTrainLogMap = "LearningTrainLogMap";

	public static String SESSION_UserLearnTraceMap = "UserLearnTraceMap";

	public static String SESSION_UserTrainTraceMap = "UserTrainTraceMap";

	// 远程文件操作服务器
	public static String FileOperateServer = "FileOperateServer";
	// ftp操作验证字符戳
	public static String ftpServiceValidate = "ftpServiceValidate";

	// 课件转换类型
	public static String CoursewareConversionType = "CoursewareConversionType";
	
	public static String coursewareTypes = "coursewareTypes";

	// 参与openoffic转换文件类型定义
	public static final String CONVERFILEEXT = "CONVERFILEEXT";

	// 源文件夹路径
	public static final String RESOURCE_FOLDER = "RESOURCE_FOLDER";

	public static final String UsingName = "UsingName";

	public static final String loginLocation = "loginLocation";

	public static final String chatroomStart = "chatroomStart";
	
	public static final String chatroomAddr = "chatroomAddr";

	public static final String TrainIsOnlineStart = "TrainIsOnlineStart";
	
	public static final String TrainIsOnlieAddr = "TrainIsOnlieAddr";
	
	public static final String mongodbStart = "mongodbStart";
	
	public static final String huarui_m = "huarui_m";
	
	public static final String huarui_o = "huarui_o";
	
	public static final String huarui_local_m = "huarui_local_m";
	
	public static final String huarui_local_o = "huarui_local_o";
	
	public static final String isAutoSyn = "IsAutoSyn";
	
	//短信参数
	public static final String SMSSerialNo = "SMSSerialNo";
	public static final String SMSKey = "SMSKey";
	public static final String SMSPassword = "SMSPassword";
	
	//缓存前台课程总时长(学习)
	public static final String PREFIX_BEFORE_LEARNINGTIME = "prefix_before_learningtime";
	
	//缓存前台课件时长(学习)
	public static final String PREFIX_BEFORE_COURSEWARETIME = "prefix_before_coursewaretime";
	
	//缓存前台课件列表(学习)
	public static final String PREFIX_BEFORE_COURSEWAREList = "prefix_before_coursewarelist";
	
	//缓存前台课程列表(学习)
	public static final String PREFIX_BEFORE_COURSEList = "prefix_before_courselist";
	
	//缓存前台课件总数(学习)
	public static final String PREFIX_BEFORE_COURSEWARSENUM = "prefix_before_coursewarsenum";
	
	//缓存前台资源列表(学习)
	public static final String PREFIX_BEFORE_RELATEDRESOURCESLIST = "prefix_before_relatedresourceslist";
	
	//缓存前台课程引用的课件总数and资源总数(学习)
	public static final String PREFIX_BEFORE_COURSEWAREAMOUNT = "prefix_before_coursewareamount";
	
	//缓存前台课件类型(学习)
	public static final String PREFIX_BEFORE_COURSEWARETYPE = "prefix_before_coursewaretype";
	
	//缓存前台课件信息(学习)
	public static final String PREFIX_BEFORE_COURSEWAREMESSAGE = "prefix_before_coursewaremessage";
	
	//缓存前台资源关联方式(学习)
	public static final String PREFIX_BEFORE_RELATESOURCETYPE = "prefix_before_relatesourcetype";
	
	//缓存前台评价列表(学习)
	public static final String PREFIX_BEFORE_EVALULIST = "prefix_before_evalulist";
	
	//缓存前台课程id(培训)
	public static final String PREFIX_BEFORE_TRAIN_DEFAULTCID = "prefix_before_train_defaultcid";
	
	//缓存前台课件id(培训)
	public static final String PREFIX_BEFORE_TRAIN_COURSECWID = "prefix_before_train_coursecwid";
	
	//缓存前台项目总时长(培训)
	public static final String PREFIX_BEFORE_TRAIN_PROJECTTIME = "prefix_before_train_projecttime";
	
	//缓存前台项目结业方式(培训)
	public static final String PREFIX_BEFORE_TRAIN_ENDTRAINTYPE = "prefix_before_train_endtraintype";
	
	//缓存前台项目众包下课程(培训)
	public static final String PREFIX_BEFORE_TRAIN_CROWDCOURSE = "prefix_before_train_crowdCourse";
	
	//缓存用户信息
	public static final String PREFIX_BEFORE_USER_MESSAGE = "prefix_before_user_message";

	//缓存前端选课中心的子课程前缀
	public static final String PREFIX_BEFORE_XKZX_SON = "prefix_before_xkzx_son";

	/**
	 * Excel导入模板路径
	 */
	public static final String ExcelImp_Template_Path = "/static/template/excelImport/";

	/**
	 * Excel导出模板路径
	 */
	public static final String ExcelExp_Template_Path = "/static/template/excelExport/";

	/**
	 * Excel导出模板路径
	 */
	public static final String Freemarker_Template_Path = "/static/template/freemarker/";

	/**
	 * 文件上传临时路径
	 */
	public static final String Upload_Temp_Path = "/static/tmp/";

}





