package com.gss.web.common.suppot;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@WebAppConfiguration
public abstract class BaseService {

}
