package com.cqupt.wzy.facedetection.common.util;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class AipFaceUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AipFaceUtil.class);

    // 设置APPID/AK/SK
    public static final String APP_ID = "15547555";
    public static final String API_KEY = "9rUE7Wx4HFpGBSbLefGFNdPX";
    public static final String SECRET_KEY = "SV50Pi8lVQQGQ81yiGjKWUPSxmTprNpV";

    // 初始化一个AipFace
    private static AipFace client= new AipFace(APP_ID, API_KEY, SECRET_KEY);

    /**
     * 人脸检测
     *@param imageType 图片传入类型，例如'BASE64'、'URL'...
     *@param  image    传入图片，传入BASE64字符串或URL字符串或FACE_TOKEN字符串，取决于image_type参数
     *@param options   传入可选参数调用接口
     */
    public static Object detect(String image, String imageType, HashMap<String, String> options){
        // 置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        // 人脸检测
        JSONObject res = client.detect(image, imageType, options);

        return res.toString(2);
    }

    /**
     * 人脸搜索
     *@param imageType 图片传入类型，例如'BASE64'、'URL'...
     *@param  image    传入图片，传入BASE64字符串或URL字符串或FACE_TOKEN字符串，取决于image_type参数
     *@param options   传入可选参数调用接口
     *@param groupIdList 从指定的group中进行查找 用逗号分隔
     */
    public static Object search(String image, String imageType, String groupIdList, HashMap<String, String> options){
        // 置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        // 人脸搜索
        JSONObject res = client.search(image, imageType, groupIdList, options);

        return res.toString(2);
    }

    /**
     * 人脸注册
     *@param imageType 图片传入类型，例如'BASE64'、'URL'...
     *@param  image    传入图片，传入BASE64字符串或URL字符串或FACE_TOKEN字符串，取决于image_type参数
     *@param options   传入可选参数调用接口
     *@param groupId   人脸库id
     *@param userId    用户id
     */
    public static Object addUser(String image, String imageType, String groupId, String userId ,HashMap<String ,String> options){
        // 置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        // 人脸注册
        JSONObject res = client.addUser(image, imageType, groupId, userId, options);

        return res.toString(2);
    }

    /**
     * 人脸更新
     *@param imageType 图片传入类型，例如'BASE64'、'URL'...
     *@param  image    传入图片，传入BASE64字符串或URL字符串或FACE_TOKEN字符串，取决于image_type参数
     *@param options   传入可选参数调用接口
     *@param groupId   人脸库id
     *@param userId    用户id
     */
    public static Object updateUser(String image, String imageType, String groupId, String userId ,HashMap<String, String> options){
        // 置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        // 人脸更新
        JSONObject res = client.updateUser(image, imageType, groupId, userId, options);

        return res.toString(2);
    }

    /**
     * 人脸删除
     *@param userId    用户id
     *@param groupId   人脸库id，可为空，为空时删除所有人脸库里的用户信息
     *@param faceToken 需要删除的人脸图片token
     */
    public static Object faceDelete(String userId, String groupId, String faceToken, HashMap<String, String> options){
        // 置网络连接参数
        client.setConnectionTimeoutInMillis(2000);

        // 人脸删除
        JSONObject res = client.faceDelete(userId, groupId, faceToken, options);

        return res.toString(2);
    }
}
