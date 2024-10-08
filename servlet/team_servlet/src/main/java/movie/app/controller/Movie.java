package movie.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.kh.app.model.vo.CommunityVO;
import movie.app.service.MovieService;
import movie.app.service.MovieServiceImp;


@WebServlet("/movie")
public class Movie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService postService = new MovieServiceImp();
	   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	//서비스에게 등록된 커뮤니티 목록을 가져오라고 요청
    	List<CommunityVO> list = postService.getCommunityList();
    	//화면에 커뮤니티 목록을 전송
    	request.setAttribute("list", list);
    	request.getRequestDispatcher("/WEB-INF/views/community.jsp").forward(request, response);
	}
}
