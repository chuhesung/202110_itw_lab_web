package edu.spring.ex02.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex02.domain.Reply;
import edu.spring.ex02.service.ReplyService;

@RestController // REST 서비스를 지원하는 콘트롤러 
// RestController 클래스의 모든 메서드들이 리턴하는 값은 view(JSP)를 찾기 위한 문자열이 아니라 
// 응답(response)으로 클라이언트에게 전달되는 데이터.
@RequestMapping(value = "/replies")
public class ReplyRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ReplyRestController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<Reply>> readAllReplies(@PathVariable(name = "bno") Integer bno) {
		log.info("readAllReplies(bno={})", bno);
		
		// Service 객체의 메서드를 호출해서 해당 글 번호(bno)의 모든 댓글 리스트를 작성.
		List<Reply> replyList = replyService.select(bno);
		
		// 댓글 리스트를 ResponseEntity 객체에 넣어서 클라이언트 전송.
		ResponseEntity<List<Reply>> entity = new ResponseEntity<List<Reply>>(replyList, HttpStatus.OK);
		
		// POM.xml 파일에서 jackson-databind 라이브러리가 포함되어 있어야 함. 
		// 리턴하는 ResponseEntity 객체를 DispatcherServlet이 jackson-databind 라이브러리를 사용해서
		// JSON 문자열로 변환하고 클라이언트로 전송.
		return entity;
	}

}
