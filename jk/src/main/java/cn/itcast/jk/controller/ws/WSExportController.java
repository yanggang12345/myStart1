package cn.itcast.jk.controller.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>
 * Title:WSExportController
 * <p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @date 2017年6月27日 下午5:25:08
 * @author 123456
 *         <p>
 * 		杨刚
 *         </p>
 */
@Controller
public class WSExportController {

	@RequestMapping("/ws/export/toedit.action")
	public String toedit() {
		return "/ws/export/ajaxExport.jsp";
	}
}
