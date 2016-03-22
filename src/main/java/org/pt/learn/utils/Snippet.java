package org.pt.learn.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Snippet {
	public static final List<String> SEX_OPTIONS = Collections.unmodifiableList(
			    Arrays.asList(new String[] {"MALE", "FEMALE"}));
	
	/*public static final List<String> LIST_SUBJECTS = Collections.unmodifiableList(
				 Arrays.asList(new String[]{"Art" 
						 , "Biology" 
						 , "Chemistry" , "Commerce" , "Computer" 
						 , "Design & technology" , "Drama" 
						 , "English" 
						 , "Food-technology" , "Foreign-Languages" 
						 , "Geography" 
						 , "Health-and-Hygiene" , "History" 
						 , "Literature" , "Languages" 
						 , "Maths" , "Music" 
						 , "Physics" , "Physical-Education" , "PSHE" , "Psychology"  
						 , "Science" , "Study-Skills" , "Sociology" , "Home-Economics"	}));*/
	public static final List<String> LIST_SUBJECTS = Collections.unmodifiableList(
			 Arrays.asList(new String[]{"Art" 
					 , "Biology" 
					 , "Chemistry" , "Commerce" , "Computer" 
					 , "English" , "Foreign-Languages" 
					 , "Geography" , "History" 
					 , "Literature" , "Languages" 
					 , "Maths" , "Music" 
					 , "Physics" , "Science" , "Study-Skills"}));
	
	/*public static final List<String> LIST_COURSE_CATEGORY = Collections.unmodifiableList(
			 Arrays.asList(new String[]{
					 "Pre-school", "Kindergarten", 
					 "Primary school", "Middle school", 
					 "Secondary school", "Higher secondary", 
					 "graduate", "Postgraduate",	
					 "Competitive exams", "certification exam", 
					 "GENERAL"	
			 } ));*/
	public static final List<String> LIST_COURSE_CATEGORY = Collections.unmodifiableList(
			 Arrays.asList(new String[]{ 
					 "Secondary school", "Higher secondary", 
					 "graduate", "Postgraduate",	
					 "Competitive exams", "certification exam", 
					 "GENERAL"	
			 } ));
	
	public static final List<String> LIST_LANGUAGES = Collections.unmodifiableList(
				Arrays.asList(new String[]{"Hindi" , "English"}));
	
	/*public static final List<String> LIST_COURSE_TYPE = Collections.unmodifiableList(
			Arrays.asList(new String[]{ 
					"TheMagazineCourse" , "FoundationCourse",
					 "IntensiveLearningExperienceCourse", "ShortCourse" , 
					 "MediumCourse", "FullLengthCourse"}));*/
	public static final List<String> LIST_COURSE_TYPE = Collections.unmodifiableList(
			Arrays.asList(new String[]{ 
					"TheMagazineCourse"}));
	
	public static final List<String> COURSE_DESCRIPTION_LIST = Collections.unmodifiableList(
			Arrays.asList( new String[]{
				"101.Introduction", "102.General information", "103.Student learning outcomes", "104.Syllabus", 
				"105.Instructional method", "106.References , Resources and Course materials",
				"107.Policy statements, links", 
				"108.Assignments, assessments and evaluation", "109.Prerequisites and Requirements", 
				"110.pace of the course and time commitment", "111.Calendar of events"	
			} ));
	
	
	public static final List<String> MAGAZINE_SCHEDUAL_LIST = Collections.unmodifiableList(
			Arrays.asList( new String[]{
					"DAILY", "ALTERNATE_DAY", "TWICE_A_WEEK","THRICE_A_WEEK",
					"MON_WED_FRI", "TUE_THUS_SAT", "WEEKLY" , "ALTERNATE WEEK", "MONTHLY"
			} ));
	
}

