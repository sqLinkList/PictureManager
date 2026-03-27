package com.yupi.yupicturebackend.config;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.hunyuan.v20230901.HunyuanClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "tencent.cloud")
@Data
public class HunyuanConfig {

    private String secretId;

    private String secretKey;

    private String region;

    private HunyuanProperties hunyuan = new HunyuanProperties();

    @Data
    public static class HunyuanProperties {
        private String endpoint = "hunyuan.tencentcloudapi.com";
    }

    @Bean
    public HunyuanClient hunyuanClient() {
        Credential credential = new Credential(secretId, secretKey);
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(hunyuan.getEndpoint());
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        return new HunyuanClient(credential, region, clientProfile);
    }
}
