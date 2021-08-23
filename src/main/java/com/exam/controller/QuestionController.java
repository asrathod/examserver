package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;



@RestController
@CrossOrigin
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQustion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.addQuestion(question));
		
	}
	
	//update qustion
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
		
	}
	
	//get questions of quiz
	@GetMapping("/quiz/{qid}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
		
		/*
		 * Quiz quiz = new Quiz(); quiz.setQid(qid); Set<Question> questionsOfQuiz =
		 * this.questionService.getQuestionsofQuiz(quiz); return
		 * ResponseEntity.ok(questionsOfQuiz);
		 */
		
		Quiz quiz = this.quizService.getQuiz(qid);
		Set<Question> question = quiz.getQuestions();
		List list = new ArrayList(question);
		
		if(list.size() > Integer.parseInt(quiz.getNumberofQuestion())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberofQuestion() + 1));
		}
		Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	//get single question
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId") Long quesId) {
		return this.questionService.getQustion(quesId);	
	}
	
	//delete question
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId") Long quesId) {
		this.questionService.deleteQustion(quesId);
	}
}
