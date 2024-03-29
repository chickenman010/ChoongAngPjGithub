<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.bg-yellow {
  background-color: #fdb933; /* #ffc107 */
}
</style>
<table>
	<tr>
		<td width="70%" style="vertical-align:top">

			<div class="d-flex align-items-center p-3 my-3 text-white bg-yellow rounded shadow-sm">
				<img class="me-3" src="/bootstrap-5.3.2-examples/assets/brand/bootstrap-logo-white.svg" alt="" width="48" height="38">
				<div class="lh-1">
					<h1 class="h6 mb-0 text-white lh-1">PMS (Project Management System)</h1>
					<small>Since 2023</small>
				</div>
			</div>
		
			<!-- PMS소개란 -->
			<div class="dropdown-menu position-static d-flex flex-column flex-lg-row align-items-stretch justify-content-start p-3 rounded-3 shadow mt-4" data-bs-theme="light">
				<nav class="col-lg-8">
					<ul class="list-unstyled d-flex flex-column gap-2">
						<li>
							<a href="#" class="btn btn-hover-light rounded-2 d-flex align-items-start gap-2 py-2 px-3 lh-sm text-start">
								<svg class="bi" width="24" height="24"><use xlink:href="#image-fill"></use></svg>
								<div>
									<strong class="d-block">전체 작업 체계화/시각화 제공</strong>
									<small>Take a tour through the product</small>
								</div>
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-hover-light rounded-2 d-flex align-items-start gap-2 py-2 px-3 lh-sm text-start">
								<svg class="bi" width="24" height="24"><use xlink:href="#image-fill"></use></svg>
								<div>
									<strong class="d-block">작업진행 과정 공유로 원활한 의사소통 가능</strong>
									<small>Take a tour through the product</small>
								</div>
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-hover-light rounded-2 d-flex align-items-start gap-2 py-2 px-3 lh-sm text-start">
								<svg class="bi" width="24" height="24"><use xlink:href="#image-fill"></use></svg>
								<div>
									<strong class="d-block">프로젝트 스케쥴 관리의 편의성</strong>
									<small>Take a tour through the product</small>
								</div>
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-hover-light rounded-2 d-flex align-items-start gap-2 py-2 px-3 lh-sm text-start">
								<svg class="bi" width="24" height="24"><use xlink:href="#image-fill"></use></svg>
								<div>
									<strong class="d-block">개발 표준화 제공 및 프로젝트 품질 향상</strong>
									<small>Take a tour through the product</small>
								</div>
							</a>
						</li>
						<li>
							<a href="#" class="btn btn-hover-light rounded-2 d-flex align-items-start gap-2 py-2 px-3 lh-sm text-start">
								<svg class="bi" width="24" height="24"><use xlink:href="#image-fill"></use></svg>
								<div>
									<strong class="d-block">효율적인 프로젝트 산출물 관리 (문서화 폴더링)</strong>
									<small>Take a tour through the product</small>
								</div>
							</a>
						</li>
					</ul>
				</nav>
				<div class="d-none d-lg-block vr mx-4 opacity-10">&nbsp;</div>
					<hr class="d-lg-none">
					<div class="col-lg-auto pe-3">
						<nav>
							<ul class="d-flex flex-column gap-2 list-unstyled small">
								<li><a href="#" class="link-offset-2 link-underline link-underline-opacity-25 link-underline-opacity-75-hover">Documentation</a></li>
								<li><a href="#" class="link-offset-2 link-underline link-underline-opacity-25 link-underline-opacity-75-hover">Use cases</a></li>
								<li><a href="#" class="link-offset-2 link-underline link-underline-opacity-25 link-underline-opacity-75-hover">API status</a></li>
								<li><a href="#" class="link-offset-2 link-underline link-underline-opacity-25 link-underline-opacity-75-hover">Partners</a></li>
								<li><a href="#" class="link-offset-2 link-underline link-underline-opacity-25 link-underline-opacity-75-hover">Resources</a></li>
							</ul>
						</nav>
					</div>				
				</div>
			</div>
			
			<div class="d-flex flex-column flex-md-row gap-4 py-md-5 align-items-center justify-content-center"> <!-- p-4 -->
			
				<!-- TO-DO LIST -->
				<div class="dropdown-menu d-block position-static pt-0 mx-0 rounded-3 shadow overflow-hidden w-100per" data-bs-theme="light" style="height:354px">
					<form class="p-2 mb-2 bg-body-tertiary border-bottom">
						<input type="search" class="form-control" autocomplete="false" placeholder="오늘 할 일을 메모합니다...">
					</form>
					    
					<div class="list-group">
						<label class="list-group-item d-flex gap-3 bg-body-tertiary">
						      <input class="form-check-input form-check-input-placeholder bg-body-tertiary flex-shrink-0 pe-none" disabled="" type="checkbox" value="" style="font-size: 1.375em;">
						      <span class="pt-1 form-checked-content">
						        <span contenteditable="true" class="w-100">Boot Sprint Project 생성하기</span>
						        <small class="d-block text-body-secondary">
						          <svg class="bi me-1" width="1em" height="1em"><use xlink:href="#list-check"></use></svg>
						          Choose list...
						        </small>
						      </span>
						</label>
						<label class="list-group-item d-flex gap-3">
							<input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="" style="font-size: 1.375em;">
							<span class="pt-1 form-checked-content">
								<strong>index파일 및 각 담당자별 폴더 및 파일 구성하기</strong>
								<small class="d-block text-body-secondary">
									<svg class="bi me-1" width="1em" height="1em"><use xlink:href="#calendar-event"></use></svg>
									1:00–2:00pm
								</small>
							</span>
						</label>
						<label class="list-group-item d-flex gap-3">
							<input class="form-check-input flex-shrink-0" type="checkbox" value="" style="font-size: 1.375em;">
							<span class="pt-1 form-checked-content">
								<strong>Oracle DB에 ERD F/E으로 Table생성하기</strong>
								<small class="d-block text-body-secondary">
									<svg class="bi me-1" width="1em" height="1em"><use xlink:href="#calendar-event"></use></svg>
									2:00–2:30pm
								</small>
							</span>
						</label>
						<label class="list-group-item d-flex gap-3">
							<input class="form-check-input flex-shrink-0" type="checkbox" value="" style="font-size: 1.375em;">
							<span class="pt-1 form-checked-content">
								<strong>DB Table에 샘플 데이타 생성하기</strong>
								<small class="d-block text-body-secondary">
									<svg class="bi me-1" width="1em" height="1em"><use xlink:href="#alarm"></use></svg>
									Tomorrow
								</small>
							</span>
						</label>
						
					</div>
				</div>

		
				<!-- 달력 --> 
				<div class="dropdown-menu d-block position-static p-2 mx-0 shadow rounded-3 w-100per" data-bs-theme="light" style="z-index:auto"><!-- w-340px -->
					<div class="d-grid gap-1">
						<div class="cal">
							<div class="cal-month">
								<button class="btn cal-btn" type="button">
						    		<svg class="bi" width="16" height="16"><use xlink:href="#arrow-left-short"></use></svg>
								</button>
						          <strong class="cal-month-name">June</strong>
						          <select class="form-select cal-month-name d-none">
						            <option value="January">January</option>
						            <option value="February">February</option>
						            <option value="March">March</option>
						            <option value="April">April</option>
						            <option value="May">May</option>
						            <option selected="" value="June">June</option>
						            <option value="July">July</option>
						            <option value="August">August</option>
						            <option value="September">September</option>
						            <option value="October">October</option>
						            <option value="November">November</option>
						            <option value="December">December</option>
						          </select>
						          <button class="btn cal-btn" type="button">
						            <svg class="bi" width="16" height="16"><use xlink:href="#arrow-right-short"></use></svg>
						          </button>
							</div>
							<div class="cal-weekdays text-body-secondary">
						          <div class="cal-weekday">Sun</div>
						          <div class="cal-weekday">Mon</div>
						          <div class="cal-weekday">Tue</div>
						          <div class="cal-weekday">Wed</div>
						          <div class="cal-weekday">Thu</div>
						          <div class="cal-weekday">Fri</div>
						          <div class="cal-weekday">Sat</div>
							</div>
						 	<div class="cal-days">
						          <button class="btn cal-btn" disabled="" type="button">30</button>
						          <button class="btn cal-btn" disabled="" type="button">31</button>
						
						          <button class="btn cal-btn" type="button">1</button>
						          <button class="btn cal-btn" type="button">2</button>
						          <button class="btn cal-btn" type="button">3</button>
						          <button class="btn cal-btn" type="button">4</button>
						          <button class="btn cal-btn" type="button">5</button>
						          <button class="btn cal-btn" type="button">6</button>
						          <button class="btn cal-btn" type="button">7</button>
						
						          <button class="btn cal-btn" type="button">8</button>
						          <button class="btn cal-btn" type="button">9</button>
						          <button class="btn cal-btn" type="button">10</button>
						          <button class="btn cal-btn" type="button">11</button>
						          <button class="btn cal-btn" type="button">12</button>
						          <button class="btn cal-btn" type="button">13</button>
						          <button class="btn cal-btn" type="button">14</button>
						
						          <button class="btn cal-btn" type="button">15</button>
						          <button class="btn cal-btn" type="button">16</button>
						          <button class="btn cal-btn" type="button">17</button>
						          <button class="btn cal-btn" type="button">18</button>
						          <button class="btn cal-btn" type="button">19</button>
						          <button class="btn cal-btn" type="button">20</button>
						          <button class="btn cal-btn" type="button">21</button>
						
						          <button class="btn cal-btn" type="button">22</button>
						          <button class="btn cal-btn" type="button">23</button>
						          <button class="btn cal-btn" type="button">24</button>
						          <button class="btn cal-btn" type="button">25</button>
						          <button class="btn cal-btn" type="button">26</button>
						          <button class="btn cal-btn" type="button">27</button>
						          <button class="btn cal-btn" type="button">28</button>
						
						          <button class="btn cal-btn" type="button">29</button>
						          <button class="btn cal-btn" type="button">30</button>
						          <button class="btn cal-btn" type="button">31</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</td>
		<td width="30%" style="vertical-align:top">
		
<div class="list-group p-3 px-md-3">
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">List group item heading</h6>
          <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>
        </div>
        <small class="opacity-50 text-nowrap">now</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">Another title here</h6>
          <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>
        </div>
        <small class="opacity-50 text-nowrap">3d</small>
      </div>
    </a>
    <a href="#" class="list-group-item list-group-item-action d-flex gap-3 py-3" aria-current="true">
      <img src="https://github.com/twbs.png" alt="twbs" width="32" height="32" class="rounded-circle flex-shrink-0">
      <div class="d-flex gap-2 w-100 justify-content-between">
        <div>
          <h6 class="mb-0">Third heading</h6>
          <p class="mb-0 opacity-75">Some placeholder content in a paragraph.</p>
        </div>
        <small class="opacity-50 text-nowrap">1w</small>
      </div>
    </a>
  </div>
  
			<div class="list-group p-3 px-md-3">
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="">
			      <span>
			        First checkbox
			        <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Second checkbox
			        <small class="d-block text-body-secondary">Some other text goes here</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Third checkbox
			        <small class="d-block text-body-secondary">And we end with another snippet of text</small>
			      </span>
			    </label>
			</div>
			<div class="list-group p-3 px-md-3">
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="">
			      <span>
			        First checkbox
			        <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Second checkbox
			        <small class="d-block text-body-secondary">Some other text goes here</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Third checkbox
			        <small class="d-block text-body-secondary">And we end with another snippet of text</small>
			      </span>
			    </label>
			</div>
			<div class="list-group p-3 px-md-3">
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="" checked="">
			      <span>
			        First checkbox
			        <small class="d-block text-body-secondary">With support text underneath to add more detail</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Second checkbox
			        <small class="d-block text-body-secondary">Some other text goes here</small>
			      </span>
			    </label>
			    <label class="list-group-item d-flex gap-2">
			      <input class="form-check-input flex-shrink-0" type="checkbox" value="">
			      <span>
			        Third checkbox
			        <small class="d-block text-body-secondary">And we end with another snippet of text</small>
			      </span>
			    </label>
			</div>
			
  
  
		</td>
	</tr>
</table>			