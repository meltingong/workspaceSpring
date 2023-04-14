package com.itwill.ilhajob.corp.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.type.LocalDateType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.service.AppService;
import com.itwill.ilhajob.corp.dto.CorpDto;
import com.itwill.ilhajob.corp.dto.CorpImageDto;
import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.entity.CorpImage;
import com.itwill.ilhajob.corp.entity.Manager;
import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corp.repository.ManagerRepository;
import com.itwill.ilhajob.corp.service.CorpImageService;
import com.itwill.ilhajob.corp.service.CorpService;
import com.itwill.ilhajob.corp.service.ManagerService;
import com.itwill.ilhajob.corp.service.RecruitService;
import com.itwill.ilhajob.user.controller.LoginCheck;
import com.itwill.ilhajob.user.dto.ReviewDto;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.service.UserService;


@Controller
public class CorpController {

	@Autowired
	private CorpService corpService;
	@Autowired
	private CorpImageService corpImageService;
	@Autowired
	private RecruitService recruitService;

	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private AppService appService;

	
//	@RequestMapping("/index")
//	public String main() {
//		String forward_path = "index";
//		return forward_path;
//	}

	@RequestMapping("/corp-list")

	public String corp_list(Model model) throws Exception {
		List<CorpDto> corpList = corpService.findCorpAll();
		model.addAttribute("corpList", corpList);
		String forward_path = "corp-list";
			
		return forward_path;

	}
	
	@RequestMapping("corp-detail")
	public String corp_detail_view(@RequestParam("corpLoginId") String corpLoginId, HttpServletRequest request,Model model) throws Exception {
		String sUserId = (String)request.getSession().getAttribute("sUserId");
		if(sUserId ==null) {
			CorpDto corpDto=corpService.findCorp(corpLoginId);
			model.addAttribute("corp", corpDto);
			
			//공고 목록 뿌리기
			List<RecruitDto> recruitList=recruitService.findRecruitAll();
			List<RecruitDto> recruitList1=new ArrayList<>();
			for(RecruitDto recruitDto: recruitList) {
				if(recruitDto.getCorp().getId()==corpDto.getId()) {
					recruitList1.add(recruitDto);
				}
			}
			model.addAttribute("recruitList",recruitList1);
			//리뷰 목록 뿌리기
			
			List<ReviewDto> reviewList = corpService.findReviewList(corpDto.getId());
			model.addAttribute("reviewList",reviewList);
		}else {
			CorpDto corpDto=corpService.findCorp(corpLoginId);
			model.addAttribute("corp", corpDto);
			
			//공고 목록 뿌리기
			List<RecruitDto> recruitList=recruitService.findRecruitAll();
			List<RecruitDto> recruitList1=new ArrayList<>();
			for(RecruitDto recruitDto: recruitList) {
				if(recruitDto.getCorp().getId()==corpDto.getId()) {
					recruitList1.add(recruitDto);
				}
			}
			model.addAttribute("recruitList",recruitList1);
			//String sUserId = (String)request.getSession().getAttribute("sUserId");
			UserDto loginUser = userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			
			//리뷰 목록 뿌리기
			
			List<ReviewDto> reviewList = corpService.findReviewList(corpDto.getId());
			model.addAttribute("reviewList",reviewList);
		}
		
		return "corp-detail";

	}

//	@RequestMapping("/login")
//	public String login() {
//		String forward_path = "login";
//		return forward_path;
//	}
	@PostMapping("corp_login_action")
	public String corp_login_action(@ModelAttribute("fcorp") CorpDto corpDto, Model model, HttpSession session)
			throws Exception {
		String forwardPath = "";
		try {
			corpService.login(corpDto.getCorpLoginId(), corpDto.getCorpPassword());
			session.setAttribute("sCorpId", corpDto.getCorpLoginId());
			System.out.println(corpDto.getCorpLoginId());
			forwardPath = "redirect:dashboard";
		} catch (CorpNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1", e.getMessage());
			forwardPath = "login";
		} catch (PasswordMismatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2", e.getMessage());
			forwardPath = "login";
		}
		return forwardPath;
	}

	/*****************************************************************************
	 * 대쉬보드
	 ******************************************************************************/

	@RequestMapping("/dashboard")
	public String corp_dashboard_view(HttpServletRequest request) throws Exception {
		String forwardPath = "";

		/************** login check **************/
		request.getSession().setAttribute("id", "1L"); //임시로 아이디 로그인상태
		request.getSession().setAttribute("sCorpId", "corp_01"); //임시로 아이디 로그인상태
		String sCorpId =(String)request.getSession().getAttribute("sCorpId");
		if(sCorpId==null) {
			forwardPath= "redirect:login";
		}else {
			//System.out.println(loginCorp);
			CorpDto loginCorp=corpService.findCorp(sCorpId);
			request.setAttribute("loginCorp", loginCorp);
			forwardPath="dashboard";
		}
		return forwardPath;
	}

	@RequestMapping("/dashboard-company-profile")
	public String corp_dashboard_company_profile(HttpServletRequest request, Model model) throws Exception {

		String forwardPath = "";
		String sCorpId = (String) request.getSession().getAttribute("sCorpId");
		CorpDto corpDto = corpService.findCorp(sCorpId);
		/***********CorpImage 코프 로그인아이디로 리스트뽑아오기*****************/
		List<CorpImageDto> corpImageList = corpImageService.selectAll();
		List<CorpImageDto> corpImageList1 = new ArrayList<CorpImageDto>();
		for (CorpImageDto corpImageDto : corpImageList) {
			if(corpImageDto.getCorp().getCorpLoginId()==corpDto.getCorpLoginId()) {
				corpImageList1.add(corpImageDto);
			}
		}
		/*******************************************************************/
		model.addAttribute("corp", corpDto);
		model.addAttribute("corpImageList", corpImageList1);
		forwardPath = "dashboard-company-profile";
		
		return forwardPath;
	}

	@PostMapping("/corp-update-action")
	public String corp_update_action(@ModelAttribute("corp") CorpDto corpDto,
			 HttpServletRequest request)throws Exception {
		Long id = corpDto.getId();
		System.out.println(corpDto);
		corpService.update(id, corpDto);
		request.setAttribute("corpLoginId", corpDto.getCorpLoginId());
		return "corp-detail";
	}

	@RequestMapping("/dashboard-manage-job")
	public String corp_dashboard_manage_job(HttpServletRequest request,Model model) throws Exception {
		//회사의 작성 공고 띄우기
		String sCorpId = (String) request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findCorp(sCorpId);
		List<RecruitDto> recruitList=recruitService.findAllByCorpId(corpDto.getId());
		model.addAttribute("recruitList",recruitList);
		
		// 지원자 숫자 보여주기->일단 보류
		//List<Integer> countList = new ArrayList<>();
		//Long appCount = appService.findAppCountByCorpId(sCorpId);
		//System.out.println(appCount);
		//model.addAttribute("appCount", appCount);
		
		//공고 마감,진행 여부 보여주는 status도 일단 보류

		return "dashboard-manage-job";
	}
	
	//매니저리스트
	
	@RequestMapping("/dashboard-manager-list")
	public String corp_dashboard_manager_list(HttpServletRequest request,Model model) throws Exception{
		String sCorpId = (String) request.getSession().getAttribute("sCorpId");
		CorpDto corpDto=corpService.findCorp(sCorpId);
		List<ManagerDto> managerList = managerService.findManagerByCorpID(corpDto.getId());
		System.out.println(managerList);
		model.addAttribute("managerList",managerList);
		
		return "dashboard-manager-list";
	}
	
	//지원자 보기
	@RequestMapping("/dashboard-applicants")
	public String corp_dashboard_applicants(@RequestParam("id")int id, Model model) throws Exception {
		//지원자 이력서 리스트 불러오기
		List<AppDto> appList=appService.findAllByRecruitId(id);
		model.addAttribute("appList",appList);
		
		//이력서의 회원 정보 가져오기
		List<AppDto> userList=appService.findAllByUserId(id);
		model.addAttribute("userList",userList);
		
		//해당 공고 디테일 뿌리기
		RecruitDto recruit=recruitService.findRecruit(id);
		model.addAttribute("recruit", recruit);
		
		return "dashboard-applicants";
	}


	// 검색기능
	@GetMapping("/search")
	public String searchCorp() {
		return "search";
	}

	// 검색기능
	@ResponseBody
	@PostMapping("/search")
	public Map<String, Object> searchCorp(@RequestParam("query") String query, Model model) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		// 상품 검색 서비스 호출
		List<CorpDto> searchResults = corpService.searchCorpList(query);

		resultMap.put("corpList", searchResults);
		// 결과 페이지를 반환
		return resultMap;
	}
	
	//이미지 업로드
    @PostMapping("/imageUpload")
    public String handleImageUpload(MultipartFile file, Model model,HttpServletRequest request) throws Exception {
        if (!file.isEmpty()) {
            try {
                // 파일 저장 로직 구현 (예: 서버에 파일 저장, 파일 정보 DB에 저장 등)
                String fileName = file.getOriginalFilename();
                String CorpImageUrl =
                "C:\\2022-11-JAVA-DEVELOPER\\git_repositories\\final-project-team1-xxx\\src\\main\\resources\\imageUpload\\"
                + fileName;
                file.transferTo(new File(CorpImageUrl));
                
                
                CorpDto corp = corpService.findCorp((String)request.getSession().getAttribute("sUserId"));
                
                
//                CorpImageDto corpImage = new CorpImageDto(5,
//                									CorpImageUrl,
//                									1);
//                corpImageService.insertCorpImage(corpImage);
                // 파일 처리가 완료된 후에는 해당 정보를 모델에 추가하여 View로 전달
                model.addAttribute("fileName", fileName);

                // 업로드 처리가 완료된 후에는 성공 페이지 또는 결과 페이지를 반환
                return "/dashboard"; // 성공 페이지 또는 결과 페이지를 반환

            } catch (IOException e) {
                // 파일 업로드 처리 중에 예외 발생 시 에러 처리
                model.addAttribute("error", "Failed to upload file. Error: " + e.getMessage());
                return "error"; // 에러 페이지 또는 에러 처리 로직을 반환
            }
        } else {
            // 업로드된 파일이 없는 경우 예외 처리 또는 에러 처리
            model.addAttribute("error", "No file uploaded.");
            return "error"; // 에러 페이지 또는 에러 처리 로직을 반환
        }
    }
    
    
    
}


