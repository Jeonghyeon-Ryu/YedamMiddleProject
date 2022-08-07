<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<!------------ Header / Search 영역 시작 -------------->
	<div class="search-box">
		<div>
			<button class="search-button">
				<img src="img/nav-search-25.png" width="20px">
			</button>
		</div>
		<div class="search-box-item">
			<div class="header-a">
				<div>위치</div>
				<input id="location" type="text" placeholder="여행지 선택" readonly>
			</div>
		</div>
		<div class="search-box-item">
			<div class="header-a">
				<div>체크인</div>
				<input id="checkin-date" type="datetime" placeholder="날짜 추가"
					readonly>
			</div>
		</div>
		<div class="search-box-item">
			<div class="header-a">
				<div>체크아웃</div>
				<input id="checkout-date" type="datetime" placeholder="날짜 추가"
					readonly>
			</div>
		</div>
		<div class="search-box-item">
			<div>
				<div>인원</div>
				<input id="headcount" type="number" placeholder="인원 수" readonly>
			</div>
		</div>
		<div>
			<button class="filter-button">
				<img src="img/search-box-filter-20.png">
			</button>
		</div>
	</div>
	<!------------ Header / Filter 영역 시작 -------------->
	<div class="filter-container row">
		<button class="left-scroll-button" type="button">
			<img src="img/arrow-back-25.png">
		</button>
		<div class="filter-box">
			<div class="filter-inner-box">
				<div class="filter-item filter-item-first">
					<img src="img/filter-swimming-pool-25.png" class="filter-item-img">
					<div class="filter-item-name">수영장</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-kitchen-room-25.png" class="filter-item-img">
					<div class="filter-item-name">조리시설</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-hydrotherapy-25.png" class="filter-item-img">
					<div class="filter-item-name">스파</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-bbq-25.png" class="filter-item-img">
					<div class="filter-item-name">바비큐</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-activity-25.png" class="filter-item-img">
					<div class="filter-item-name">체험활동</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-sleeping-in-bed-25.png"
						class="filter-item-img">
					<div class="filter-item-name">침대방</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-view-quilt-25.png" class="filter-item-img">
					<div class="filter-item-name">온돌방</div>
				</div>
				<div class="filter-item">
					<img src="img/filter-video-projector-25.png"
						class="filter-item-img">
					<div class="filter-item-name">프로젝터</div>
				</div>
				<div class="filter-item filter-item-last" class="filter-item-img">
					<img src="img/filter-board-game-25.png">
					<div class="filter-item-name">보드게임</div>
				</div>
			</div>
		</div>
		<button class="right-scroll-button" type="button">
			<img src="img/arrow-forward-25.png">
		</button>
	</div>
	<hr>
</header>
<!-- 필터 모달창 시작 -->
<div id="modal" class="modal modal-overlay" role="dialog">
	<div class="modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>필터</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content"></div>
		<!-- Modal Footer(Optional) -->
		<div class="modal-footer">
			<button type="reset">전체 해제</button>
			<button type="button">
				<span>0</span> 건 조회
			</button>
		</div>
	</div>
</div>
<!--  -->
<div id="location-modal" class="modal modal-overlay" role="dialog">
	<div class="mini-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>지역 선택</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content">
			<div id="city" class="select animated zoomIn">
				<!-- You can toggle select (disabled) -->
				<input type="radio" name="option"> <i
					class="toggle icon icon-arrow-down"></i> <i
					class="toggle icon icon-arrow-up"></i> <span class="placeholder">시도
					선택</span> <label class="option"> <input type="radio" name="option"
					value="seoul" text="서울"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>서울</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="busan" text="부산"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>부산</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="daegu" text="대구"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>대구</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="daejeon" text="대전"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>대전</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="gwangju" text="광주"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>광주</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="ulsan" text="울산"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>울산</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="gangwon" text="강원"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>강원</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="gyeonggi" text="경기"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>경기</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="incheon" text="인천"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>인천</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="gyeongsangbuk" text="경북"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>경북</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="gyeongsangnam" text="경남"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>경남</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="chungbuk" text="충북"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>충북</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="jeonbuk" text="전북"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>전북</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="jeonnam" text="전남"> <span
					class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>전남</span>
				</label> <label class="option"> <input type="radio" name="option"
					value="jeju" text="제주"> <span class="title animated fadeIn"><i
						class="icon icon-arrow-right"></i>제주</span>
				</label>
			</div>
			<div id="regions" class="select animated zoomIn">
				<!-- You can toggle select (disabled) -->
				<input type="radio" name="option2"> <i
					class="toggle icon icon-arrow-down"></i> <i
					class="toggle icon icon-arrow-up"></i> <span class="placeholder">군구
					선택</span>
			</div>
		</div>
		<!-- Modal Footer(Optional) -->
		<div class="modal-footer">
			<button type="reset">전체 해제</button>
			<button type="button">
				<span>0</span> 건 조회
			</button>
		</div>
	</div>
</div>
<!-- 필터 모달창 시작 -->
<div id="checkin-modal" class="modal modal-overlay" role="dialog">
	<div class="mini-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>체크인/체크아웃</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content">
			<div class="my-calendar clearfix">
	          <ul class="clicked-date">
	            <li class="cal-day1"></li> -
	            <li class="cal-day2"></li>
	          </ul>
          <div class="calendar-box">
            <div class="ctr-box clearfix">
              <button type="button" title="prev" class="btn-cal prev"></button>
              <span class="cal-month"></span>
              <span class="cal-year"></span>
              <button type="button" title="next" class="btn-cal next">
              </button>
            </div>
            <table class="cal-table">
              <thead>
                <tr>
                  <th>일</th>
                  <th>월</th>
                  <th>화</th>
                  <th>수</th>
                  <th>목</th>
                  <th>금</th>
                  <th>토</th>
                </tr>
              </thead>
              <tbody class="cal-body"></tbody>
            </table>
          </div>
        </div>
		</div>
		<!-- Modal Footer(Optional) -->
		<div class="modal-footer">
			<button type="button" onclick="javascript:selectDate()">선택</button>
		</div>
	</div>
</div>

<!--  -->
<div id="headcount-modal" class="modal modal-overlay" role="dialog">
	<div class="mini-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>인원수</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content">
			<div class="filter-adult">
				<div class="headcount-label">
					<div>
						<strong>성인</strong>
					</div>
					<div>
						<small class="text-muted">만 13세 이상</small>
					</div>
				</div>
				<div class="headcount-updown-button">
					<button type="button">
						<img src="img/headcount-minus-32.png">
					</button>
					<span>0</span>
					<button type="button">
						<img src="img/headcount-plus-32.png">
					</button>
				</div>
			</div>
			<div class="filter-kid">
				<div class="headcount-label">
					<div>
						<strong>어린이</strong>
					</div>
					<div>
						<small class="text-muted">만 2~12세</small>
					</div>
				</div>
				<div class="headcount-updown-button">
					<button type="button">
						<img src="img/headcount-minus-32.png">
					</button>
					<span>0</span>
					<button type="button">
						<img src="img/headcount-plus-32.png">
					</button>
				</div>
			</div>
			<div class="filter-infant">
				<div class="headcount-label">
					<div>
						<strong>유아</strong>
					</div>
					<div>
						<small class="text-muted">만 2세 미만</small>
					</div>
				</div>
				<div class="headcount-updown-button">
					<button type="button">
						<img src="img/headcount-minus-32.png">
					</button>
					<span>0</span>
					<button type="button">
						<img src="img/headcount-plus-32.png">
					</button>
				</div>
			</div>
			<div class="filter-animal">
				<div class="headcount-label">
					<div>
						<strong>반려동물</strong>
					</div>
					<div>
						<small class="text-muted">9kg 이상 입마개 필수</small>
					</div>
				</div>
				<div class="headcount-updown-button">
					<button type="button">
						<img src="img/headcount-minus-32.png">
					</button>
					<span>0</span>
					<button type="button">
						<img src="img/headcount-plus-32.png">
					</button>
				</div>
			</div>
		</div>
		<!-- Modal Footer(Optional) -->
		<div class="modal-footer">
			<button type="reset">전체 해제</button>
			<button type="button">적용</button>
		</div>
	</div>
</div>
<div id="wishlist-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>위시리스트</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content"></div>
	</div>
</div>
<div id="reservation-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>예약내역</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="modal-content"></div>
	</div>
</div>
<div id="mypage-modal" class="modal modal-overlay" role="dialog">
	<div class="large-modal-box">
		<!-- Modal Title -->
		<div class="modal-title">
			<h5>프로필</h5>
			<div class="modal-close-button">
				<img src="img/close-20.png">
			</div>
		</div>
		<!-- Modal Content -->
		<div class="large-modal-content">
			<div id="profile-photo">
				<img src() height="48" width="48">

				<form action="login.do">
					<button type="submit" id="mypage-logout">로그아웃</button>
				</form>
			</div>

			<div id="progile-comment">
				<h3>${id }</h3>
			</div>

			<div class="mypage-info" id="info">
				<h2>나의 정보</h2>
				<ul>
					<li><a href="#"><i class="fa-solid fa-user"></i> 개인정보<span>></span></a></li>
					<li><a href="#"><i class="fa-solid fa-clipboard-list"></i>
							예약내역<span>></span></a></li>
					<li><a href="#"><i class="fa-solid fa-file-pen"></i> 후기관리<span>></span></a></li>
				</ul>
			</div>
			<hr>
			<div class="mypage-center" id="customer-center">
				<h2>고객센터</h2>
				<ul>
					<li><a href="#"><i class="fa-solid fa-circle-question"></i>
							QnA<span>></span></a></li>
					<li><a href="#"><i class="fa-solid fa-headset"></i> 1:1
							문의<span>></span></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
