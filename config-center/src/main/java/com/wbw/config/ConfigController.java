package com.wbw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wbw
 * @since 2022-6-5 16:12
 */
@RestController
@RequestMapping("user")
public class ConfigController {
    private final DataConfig dataConfig;

    @Autowired
    public ConfigController(DataConfig dataConfig) {
        this.dataConfig = dataConfig;
    }
    @GetMapping("config")
    public String config() {
        return dataConfig.getUsername() + ":" + dataConfig.getPort();
    }
}
