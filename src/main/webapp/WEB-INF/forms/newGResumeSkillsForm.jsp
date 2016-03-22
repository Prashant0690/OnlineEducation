<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../footer/taglib.jsp"%>

<!-- <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> <script type="text/javascript">
//<![CDATA[
        bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
  //]]>
 </script>
 <script>
  $(function() {
    $( "#dispatchedDate" ).datepicker({
    	dateFormat: "yy/mm/dd"
    });
  });
 </script> -->

		 <form:form class="form-horizontal" commandName="gResumeSkillsData">
		 		<%-- <form:errors path="*" /> --%>
					
					<div class="form-group">
						<label for="skillType" class="col-sm-4 control-label">Skill</label>
						<div class="col-sm-8">
							<form:input path="skillType" class="form-control" id="skillType"
								placeholder="skillType" aria-describedby="helpBlockSkillType"/>
							<span id="helpBlockSkillType" class="help-block">
							Skills can often be divided into domain-general and domain-specific 
							 For example, in the domain of work, some general skills would include
							  time management, teamwork and leadership, self motivation and others, 
							  whereas domain-specific skills would be useful only for a certain job
							  like Java , Accounting, Computers ,Finance....
							</span>
							<form:errors path="skillType" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="skillLevel" class="col-sm-4 control-label">skillLevel</label>
						<div class="col-sm-8">
							<form:select path="skillLevel" class="form-control" id="skillLevel">
					            <form:option value="1" label="Fundamental Awareness(basic knowledge)" />
					            <form:option value="2" label="Novice(limited experience)" />
					            <form:option value="3" label="Intermediate(practical application" />
					            <form:option value="4" label="Advanced(applied theory" />
					            <form:option value="5" label="Expert" />
					        </form:select>
							<form:errors path="skillLevel" />
						</div>
					</div>
					

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-8">
						<button type="submit" class="btn btn-default">ADD/UPDATE Skills</button>
					</div>
				</div>
			</form:form>
