<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>


		 <form:form class="form-horizontal" commandName="magazineQuizQuesData" action="${pageQuizQuesAction}">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="question" class="col-sm-4 control-label">Question</label>
						<div class="col-sm-8">
							<form:input path="question" class="form-control" id="question"
								placeholder="question" />
							<form:errors path="question" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="option1" class="col-sm-4 control-label">Option1</label>
						<div class="col-sm-8">
							<form:input path="option1" class="form-control" id="option1"
								placeholder="First option" />
							<form:errors path="option1" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="option2" class="col-sm-4 control-label">Option1</label>
						<div class="col-sm-8">
							<form:input path="option2" class="form-control" id="option2"
								placeholder="Second option" />
							<form:errors path="option2" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="option3" class="col-sm-4 control-label">Option3</label>
						<div class="col-sm-8">
							<form:input path="option3" class="form-control" id="option3"
								placeholder="Third option" />
							<form:errors path="option3" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="option4" class="col-sm-4 control-label">Option4</label>
						<div class="col-sm-8">
							<form:input path="option4" class="form-control" id="option4"
								placeholder="Fourth option" />
							<form:errors path="option4" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="answer" class="col-sm-4 control-label">Answer</label>
						<div class="col-sm-8">
							<form:select path="answer" class="form-control" id="answer">
								<%-- <form:option value="-" label="--Please Select"/> --%>
					            <form:option value="1" label="Option1" />
					            <form:option value="2" label="Option2" />
					            <form:option value="3" label="Option3" />
					            <form:option value="4" label="Option4" />
					        </form:select>
							<form:errors path="answer" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="ansDescription" class="col-sm-4 control-label">Answer Description</label>
						<div class="col-sm-8">
							<form:input path="ansDescription" class="form-control" id="ansDescription"
								placeholder="answer description if any" />
							<form:errors path="ansDescription" />
						</div>
					</div>
					
					<form:hidden path="quesOrderNo" />

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE Question</button>
					</div>
				</div>
			</form:form>
