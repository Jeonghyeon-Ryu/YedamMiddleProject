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
                <div>
                    <a class="header-a" href="">
                        <div>위치</div>
                        <input type="text" placeholder="여행지 선택" readonly>
                    </a>
                </div>
                <div>
                    <a class="header-a" href="">
                        <div>체크인</div>
                        <input type="datetime" placeholder="날짜 추가" readonly>
                    </a>
                </div>
                <div>
                    <a class="header-a" href="">
                        <div>체크아웃</div>
                        <input type="datetime" placeholder="날짜 추가" readonly>
                    </a>
                </div>
                <div>
                    <a href="">
                        <div>인원</div>
                        <input type="number" placeholder="인원 수" readonly>
                    </a>
                </div>
                <div>
                    <button class="filter-button">
                        <img src="img/search-box-filter-20.png">
                    </button>
                </div>
            </div>
            <!------------ Header / Filter 영역 시작 -------------->
            <div class="filter-container row" >
                <button class="left-scroll-button" type="button">
                    <img src="/WEB-INF/img/arrow-back-25.png">
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
                            <img src="img/filter-sleeping-in-bed-25.png" class="filter-item-img">
                            <div class="filter-item-name">침대방</div>
                        </div>
                        <div class="filter-item">
                            <img src="img/filter-view-quilt-25.png" class="filter-item-img">
                            <div class="filter-item-name">온돌방</div>
                        </div>
                        <div class="filter-item">
                            <img src="img/filter-video-projector-25.png" class="filter-item-img">
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