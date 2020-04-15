package com.huarui.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.huarui.common.DesEncryption;
import com.huarui.common.JsonValidator;
import com.huarui.common.SendMessageThread;
import com.huarui.common.cache.EntityCache;
import com.huarui.common.utils.excel.ExcelUtil;
import com.huarui.common.utils.sms.utils.SmsSmsSenderUtils;

public class ThreadUtils {

	private static ThreadLocal<RText> rTexts = new ThreadLocal<RText>() {
		public synchronized RText initialValue() {
			return new RText();
		}
	};
	
	private static ThreadLocal<RDate> rdate = new ThreadLocal<RDate>() {
		public synchronized RDate initialValue() {
			return new RDate();
		}
	};
	
	private static ThreadLocal<SendMessageThread> sendMessageThread = new ThreadLocal<SendMessageThread>() {
		public synchronized SendMessageThread initialValue() {
			return new SendMessageThread();
		}
	};
	
	private static ThreadLocal<ExamUtil> examUtils = new ThreadLocal<ExamUtil>() {
		public synchronized ExamUtil initialValue() {
			return new ExamUtil();
		}
	};
	
	private static ThreadLocal<DesEncryption> desEncryptions = new ThreadLocal<DesEncryption>() {
		public synchronized DesEncryption initialValue() {
			return new DesEncryption();
		}
	};
	
	private static ThreadLocal<WebUtil> webUtils = new ThreadLocal<WebUtil>() {
		public synchronized WebUtil initialValue() {
			return new WebUtil();
		}
	};
	
	private static ThreadLocal<EntityCache> entityCaches = new ThreadLocal<EntityCache>() {
		public synchronized EntityCache initialValue() {
			return new EntityCache();
		}
	};
	
	private static ThreadLocal<ReflectUtil> reflectUtils = new ThreadLocal<ReflectUtil>() {
		public synchronized ReflectUtil initialValue() {
			return new ReflectUtil();
		}
	};
	
	private static ThreadLocal<EntityUtil> entityUtils = new ThreadLocal<EntityUtil>() {
		public synchronized EntityUtil initialValue() {
			return new EntityUtil();
		}
	};
	
	private static ThreadLocal<RedisUtil> redisUtils = new ThreadLocal<RedisUtil>() {
		public synchronized RedisUtil initialValue() {
			return new RedisUtil();
		}
	};
	
	private static ThreadLocal<FileUtil> fileUtil = new ThreadLocal<FileUtil>() {
		public synchronized FileUtil initialValue() {
			return new FileUtil();
		}
	};
	
	private static ThreadLocal<FtpUtil> ftpUtil = new ThreadLocal<FtpUtil>() {
		public synchronized FtpUtil initialValue() {
			return new FtpUtil();
		}
	};

	private static ThreadLocal<CollectionUtil> collectionUtils = new ThreadLocal<CollectionUtil>() {
		public synchronized CollectionUtil initialValue() {
			return new CollectionUtil();
		}
	};
	
	private static ThreadLocal<JSONObject> jwtData = new ThreadLocal<JSONObject>() {
		public synchronized JSONObject initialValue() {
			return new JSONObject();
		}
	};

	private static ThreadLocal<ExcelUtil> excelUtils = new ThreadLocal<ExcelUtil>() {
		public synchronized ExcelUtil initialValue() {
			return new ExcelUtil();
		}
	};

	private static ThreadLocal<AESUtils> aesUtils = new ThreadLocal<AESUtils>() {
		public synchronized AESUtils initialValue() {
			return new AESUtils();
		}
	};

	private static ThreadLocal<JsonValidator> jsonValidators = new ThreadLocal<JsonValidator>() {
		public synchronized JsonValidator initialValue() {
			return new JsonValidator();
		}
	};

	public static JsonValidator getJsonValidators() {
		return jsonValidators.get();
	}

	public static AESUtils getAesUtil() {
		return aesUtils.get();
	}
	
	//短信验证码 工具类
	private static ThreadLocal<SmsSmsSenderUtils> smsSenderUtils = new ThreadLocal<SmsSmsSenderUtils>() {
		public synchronized SmsSmsSenderUtils initialValue() {
			return new SmsSmsSenderUtils();
		};
	};
	
	public static SmsSmsSenderUtils getSmsSmsSenderUtils() {
		return smsSenderUtils.get();
	}
	
	public static FileUtil getFileUtils() {
		return fileUtil.get();
	}

	public static ExcelUtil getExcelUtils() {
		return excelUtils.get();
	}
	
	public static FtpUtil getFtpUtils() {
		return ftpUtil.get();
	}
	
	public static ExamUtil getExamUtil() {
		return examUtils.get();
	}
	
	public static RText getRTex() {
		return rTexts.get();
	}
	
	public static RDate getRDate() {
		return rdate.get();
	}
	
	public static SendMessageThread getSendMessage() {
		return sendMessageThread.get();
	}

	public static DesEncryption getDesEncryption() {
		return desEncryptions.get();
	}
	
	public static WebUtil getWebUtil() {
		return webUtils.get();
	}
	
	public static EntityCache getEntityCaches() {
		return entityCaches.get();
	}
	
	public static ReflectUtil getReflectUtil() {
		return reflectUtils.get();
	}
	
	public static EntityUtil getEntityUtil() {
		return entityUtils.get();
	}
	
	public static RedisUtil getRedisUtil() {
		return redisUtils.get();
	}

	public static CollectionUtil getCollectionUtils() {
		return collectionUtils.get();
	}
	
	public static JSONObject getJwtData() {
		return jwtData.get();
	}
	
	public static void removeJwtData() {
		jwtData.remove();
	}
	
}
