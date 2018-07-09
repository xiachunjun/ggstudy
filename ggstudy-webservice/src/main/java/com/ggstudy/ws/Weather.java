package com.ggstudy.ws;

import javax.jws.WebService;

@WebService
public interface Weather {
    String queryWeather();
}