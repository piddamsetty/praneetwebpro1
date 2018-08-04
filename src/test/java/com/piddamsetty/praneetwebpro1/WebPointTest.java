package com.piddamsetty.praneetwebpro1;

import com.piddamsetty.praneetwebpro1.services.FileServices;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rewatiraman.
 */
public class WebPointTest {

    WebPoint webPoint;
    FileServices fileServices;

    @Before
    public void setup() {
        webPoint = new WebPoint();
        fileServices = new FileServices();
        String template = fileServices.resourceFileRead("templateTest");
        webPoint.template = template;
    }

    @Test
    public void testApplyTemplateMethod() {
        String teplateApplied = webPoint.applyTemplate("This is a test");
        assert(teplateApplied.trim().equals("THIS IS A TEST TEMPLATE ==> asbvdasdbvuasdbvauspdvb;jacnsIPUBaicupbaICPUBipaubcipuBCIpaubcipauBC****This is a test****"));
    }

}