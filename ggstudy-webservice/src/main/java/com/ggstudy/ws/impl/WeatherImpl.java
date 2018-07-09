package com.ggstudy.ws.impl;

import javax.jws.WebService;

import com.ggstudy.ws.Weather;

@WebService
public class WeatherImpl implements Weather{
    public String queryWeather() {
        return "今日天气为晴，偏北风二到三级";
    }
}