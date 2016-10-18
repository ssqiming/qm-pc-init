package com.qm.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.qm.common.domain.ResponseResult;
import com.qm.web.utils.JsonViewFactory;

@Controller
@RequestMapping(value = "/mytest")
public class TestControl {

	@RequestMapping(value = "/testReturn", method = RequestMethod.GET)
	public ModelAndView testReturn(HttpServletRequest request) {
		String str = "测试内容！！";
		return JsonViewFactory.buildJsonView(new ResponseResult<>(true, "测试成功！", str));
	}
}
