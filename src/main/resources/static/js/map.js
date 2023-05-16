const container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
const options = {
  //지도를 생성할 때 필요한 기본 옵션
  center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
  level: 3, //지도의 레벨(확대, 축소 정도)
};

let map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

let markers = [];

function displayMarker(positions) {
  setMarkers(null);
  // 마커 이미지의 이미지 주소입니다
  var imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

  const points = [];

  for (var i = 0; i < positions.length; i++) {
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    const iwContent = `<div class="title">
                  ${positions[i].title}
                  <div class="close" onclick="closeOverlay()" title="닫기"></div>
              </div>
              <div class="body">
                ${
                  positions[i].firstimage
                    ? `<div class="img">
                <img src="${positions[i].firstimage}" width="73" height="70">
            </div>`
                    : ``
                }
                  <div class="desc">
                      <div class="ellipsis">${positions[i].addr1}</div>
                  </div>
                  
                  <button data-contentId = ${
                    positions[i].contentId
                  } onclick="add(this.dataset)">내 여행 계획에 추가</button>
              </div>`;

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    const marker = new kakao.maps.Marker({
      map: map, // 마커를 표시할 지도
      position: positions[i].latlng, // 마커를 표시할 위치
      title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      image: markerImage, // 마커 이미지
    });

    // 인포윈도우를 생성합니다
    const infowindow = new kakao.maps.InfoWindow({
      content: iwContent,
      removable: true,
    });

    markers.push(marker);

    kakao.maps.event.addListener(marker, "click", () => {
      infowindow.open(map, marker);
    });

    kakao.maps.event.addListener(infowindow, "click", () => {
      console.log("testsetsetsetset");
    });

    points.push(positions[i].latlng);
  }

  const bounds = new kakao.maps.LatLngBounds();

  for (i = 0; i < points.length; i++) {
    //LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(points[i]);
  }

  setBounds(bounds);
}

function setBounds(bounds) {
  // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
  // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
  map.setBounds(bounds);
}

function moveCenter(lat, lng) {
  map.setCenter(new kakao.maps.LatLng(lat, lng));
}

function makeList(item) {
  if (!item) {
    alert("관련 정보가 존재하지 않습니다!");
    return;
  }

  const positions = item.map((area) => {
    return {
      title: area.title,
      latlng: new kakao.maps.LatLng(area.mapy, area.mapx),
      addr1: area.addr1,
      firstimage: area.firstimage,
      contentId: area.contentid,
    };
  });

  console.log(positions);
  hideMarkers();
  markers = [];
  displayMarker(positions);
}

// 배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}

// "마커 감추기" 버튼을 클릭하면 호출되어 배열에 추가된 마커를 지도에서 삭제하는 함수입니다
function hideMarkers() {
  setMarkers(null);
}

function resizeMap() {
  var mapContainer = document.getElementById("map");
  mapContainer.style.width = "100vw";
  mapContainer.style.height = "100vh";
}

function relayout() {
  // 지도를 표시하는 div 크기를 변경한 이후 지도가 정상적으로 표출되지 않을 수도 있습니다
  // 크기를 변경한 이후에는 반드시  map.relayout 함수를 호출해야 합니다
  // window의 resize 이벤트에 의한 크기변경은 map.relayout 함수가 자동으로 호출됩니다
  map.relayout();
}
