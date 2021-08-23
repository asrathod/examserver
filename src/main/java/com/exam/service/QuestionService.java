package com.exam.service;

import java.util.Set;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestions();
	public Question getQustion(Long questionId);
	public Set<Question> getQuestionsofQuiz(Quiz quiz);
	public void deleteQustion(Long quesId);
}
