package com.huarui.common;

public class ConstantOrder {

	/**
	 * 支付宝配置key
	 * @author panlei
	 *
	 */
	public interface aliPay{
		public static final String ALIPAY_APPID ="aplay.appid";
		public static final String ALIPAY_PRIVATEKEY= "aplay.privateKey";
		public static final String ALIPAY_PUBLICKEY= "aplay.publicKey";
		public static final String ALIPAY_PID = "aplay.pid";
		public static final String ALIPAY_RETURN_URL = "aplay.synchronizationPath";
		public static final String ALIPAY_NOTIFY_URL = "aplay.asynchronousPath";
		public static final String ALIPAY_WAY_URL = "aplay.requestGateway";
	}
	
	/**
	 * 微信支付配置key
	 */
	public interface weChatPay{
		public static final String WECHAT_APPID ="wechat.appid";
		public static final String WECHAT_MCHID ="wechat.mchid";
		public static final String WECHAT_KEY ="wechat.key";
		public static final String WECHAT_NOTIFY_URL ="wechat.notify.url";
	}
	
	/**
	 * 用户订单号失效时间
	 */
	public static final int ORDER_NUMBER_INVALID_TIME = 24;
	
	/**
	 * 用户订单失效时间
	 */
	public static final long ORDER_INVALID_TIME = 60*60*48;
	
	/**
	 * 支付订单失效key
	 */
	public interface payKeys{
		public static final String USER_ORDER ="user_order:";
	}
	
	/**
	 * 订单状态  0：待付款；1：已付款；2：已取消；3：已失效
	 */
	public interface orderStatus{
		public static final double ORDER_STATUS_0 = 0D;
		public static final double ORDER_STATUS_1 = 1D;
		public static final double ORDER_STATUS_2 = 2D;
		public static final double ORDER_STATUS_3 = 3D;
	}
	
	
	 /**
     * 套包优惠券不能超过价格
     */
    public static final float packagePrice = 700F;
    
    /**
     * 单商品优惠券不能超过价格
     */
    public static final float commodityPrice = 200F;
    
	/**
	 * 天猫自动发货
	 */
	public interface autoDelivery{
		/**
		 * AppSecret
		 */
		public static final String APP_SECRET = "sss8frc377tsr5s4f3ecsx69cw36rdvm";
		/**
		 * 是否自动发货
		 */
		public static final boolean TMALL_AUTOMATIC_DELIVERY = true;
		/**
		 * 日志状态 0：推送中 1：推送成功 2：推送失败（异常）
		 */
		public static final double LOG_TYPE_0 = 0D;
		public static final double LOG_TYPE_1 = 1D;
		public static final double LOG_TYPE_2 = 2D;
		
		/**
		 * 自动发卡类型
		 * :0 未充值 1 用户充值 2 管理员充值 3 作废 4 回滚卡
		 */
		public static final double CARD_TYPE_0 = 0;
		public static final double CARD_TYPE_1 = 1;
		public static final double CARD_TYPE_2 = 2;
		public static final double CARD_TYPE_3 = 3;
		public static final double CARD_TYPE_4 = 4;
		/**
		 * 发卡备注
		 */
		public static final String CARD_NODE = "天猫旗舰店学习卡";
		
		//套包商品
		public static final Integer COMMODITY_TYPE_0 = 0;
		//单商品
		public static final Integer COMMODITY_TYPE_1 = 1;
	}
	
}
