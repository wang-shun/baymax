package com.tongbanjie.baymax.router;

import java.util.Map;

import com.tongbanjie.baymax.jdbc.model.ParameterCommand;
import com.tongbanjie.baymax.router.model.ExecutePlan;

/**
 * SQL路由服务
 * @author dawei
 *
 */
public interface RouteService {

	ExecutePlan doRoute(String sql, Map<Integer, ParameterCommand> parameterCommand);
	
}