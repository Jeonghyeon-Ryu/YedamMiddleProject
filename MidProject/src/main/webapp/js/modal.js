let filterButton = document.querySelector('.filter-button');
            filterButton.addEventListener('click',modalOpenAction);
            let modalCloseButton = document.querySelector('.modal-close-button');
            modalCloseButton.addEventListener('click',modalCloseAction);
            function modalOpenAction(e){
                let modal = document.querySelector('#modal');
                modal.style.visibility = "visible";
                modal.style.top = 0;
                // modal.style.opacity = 1;
            }
            function modalCloseAction(e) {
                if(e.target.parentElement == document.querySelector('.modal-close-button')){
                    let modal = e.target.parentElement.parentElement.parentElement.parentElement;
                    // modal.style.visibility = "hidden";
                    modal.style.top = '-100%';
                    // modal.style.opacity = 0;
                }
            }

            // 그 외 영역 클릭 처리
            let modal = document.querySelector('#modal');
            console.log(modal);
            modal.addEventListener('click', modalClickEvent);
            function modalClickEvent(e) {
                if(e.target.classList.contains("modal-overlay")) {
                    // modal.style.visibility = "hidden";
                    modal.style.top = '-100%';
                    // modal.style.opacity = 0;
                }
                // 그 외 영역 클릭 시 필터 초기화 필요. ( 리셋버튼 Func 재사용 )
            }

            // 모달 확인버튼 이벤트 처리
            // 모달 리셋버튼 이벤트 처리