package com.bananApple.basic.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MainService {
    String getInfo(HttpServletRequest request);

    List getUUEInfo();
}
