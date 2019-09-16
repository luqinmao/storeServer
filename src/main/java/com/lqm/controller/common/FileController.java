package com.lqm.controller.common;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lqm.common.ServerResponse;
import com.lqm.pojo.StsToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HAL on 2019/5/22.
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {


    /**
     * http://localhost:8080/test/testLogBack
     * 阿里云数据存储获取token
     */
    @RequestMapping("getStsToken")
    @ResponseBody
    public ServerResponse<StsToken> getStsToken() {
        String endpoint = "sts.aliyuncs.com";
        String accessKeyId = "LTAIuGLR5h9KHKZV";
        String accessKeySecret = "9634EqXUpyEKyNIKZsjaZSko0ZvSUu";
        String roleArn = "acs:ram::1399753453494562:role/luqinmao";
        String roleSessionName = "session-name";
        try {
            // 添加endpoint（直接使用STS endpoint，前两个参数留空，无需添加region ID）
            DefaultProfile.addEndpoint("", "", "Sts", endpoint);
            // 构造default profile（参数留空，无需添加region ID）
            IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
            // 用profile构造client
            DefaultAcsClient client = new DefaultAcsClient(profile);
            final AssumeRoleRequest request = new AssumeRoleRequest();
            request.setMethod(MethodType.POST);
            request.setRoleArn(roleArn);
            request.setRoleSessionName(roleSessionName);
//            request.setPolicy(policy); // 若policy为空，则用户将获得该角色下所有权限
            request.setDurationSeconds(1000L); // 设置凭证有效时间
            final AssumeRoleResponse response = client.getAcsResponse(request);
            System.out.println("Expiration: " + response.getCredentials().getExpiration());
            System.out.println("Access Key Id: " + response.getCredentials().getAccessKeyId());
            System.out.println("Access Key Secret: " + response.getCredentials().getAccessKeySecret());
            System.out.println("Security Token: " + response.getCredentials().getSecurityToken());
            System.out.println("RequestId: " + response.getRequestId());

            String key = response.getCredentials().getAccessKeyId();
            String secret = response.getCredentials().getAccessKeySecret();
            String token = response.getCredentials().getSecurityToken();

            return ServerResponse.createBySuccess(new StsToken(key,secret,token));

        } catch (ClientException e) {
            System.out.println("Failed：");
            System.out.println("Error code: " + e.getErrCode());
            System.out.println("Error message: " + e.getErrMsg());
            System.out.println("RequestId: " + e.getRequestId());

            return ServerResponse.createByErrorMessage(e.getErrMsg());

        }
    }

}
