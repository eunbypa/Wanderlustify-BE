// 공공데이터 서비스 키
const serviceKey =
  "MsJ8m3KE1BZRPPU4a%2B4glQobhuo6032W3s7fL90AnUrHal0TqMrveuvQyEEs%2FP9VexVGAo%2BvJSn%2B1RtSF2DBFQ%3D%3D";

const mapContainer2 = document.getElementById("map"); // 지도를 표시할 div
let mapOption2 = {
  center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
  level: 3, // 지도의 확대 레벨
};

let map2 = new kakao.maps.Map(mapContainer2, mapOption2); // 지도를 생성합니다

function markMyTrip(tripsPromise) {
    Promise.all(tripsPromise)
  .then(trips => {
    const points = trips.map((trip) => ({
        latlng: new kakao.maps.LatLng(trip.latitude, trip.longitude),
        title: trip.title,
        addr1: trip.addr1,
        firstimage: trip.first_image,
      }));
    
      // 지도에 표시할 선을 생성합니다
      let polyline = new kakao.maps.Polyline({
        path: points.map((p) => p.latlng), // 선을 구성하는 좌표배열 입니다
        strokeWeight: 5, // 선의 두께 입니다
        strokeColor: "#FFAE00", // 선의 색깔입니다
        strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
        strokeStyle: "solid", // 선의 스타일입니다
      });
    
      // 지도에 선을 표시합니다
      polyline.setMap(map2);
    
      displayMarker(points);

  }).catch(error => console.error(error));

}

function setMarkers(map) {
  for (let i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}
let markers = [];

function displayMarker(positions) {
  setMarkers(null);
  // 마커 이미지의 이미지 주소입니다
  let imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

  const points = [];

  for (let i = 0; i < positions.length; i++) {
    // 마커 이미지의 이미지 크기 입니다
    let imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    console.log(positions);
    // 마커를 생성합니다
    const marker = new kakao.maps.Marker({
      map: map2, // 마커를 표시할 지도
      position: positions[i].latlng, // 마커를 표시할 위치
      title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      image: markerImage, // 마커 이미지
    });

    markers.push(marker);

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
  map2.setBounds(bounds);
}

async function getMyTrip() {
  const response = await fetch("/attraction/getMyTrip");
  const data = await response.json();
  const trips = await fetchMyTrip(data);
  markMyTrip(trips);
}

async function fetchMyTrip(data) {
  let url = `https://apis.data.go.kr/B551011/KorService1/detailCommon1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&contentTypeId=12&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&numOfRows=10&pageNo=1&contentId=`;
  
  const trips = data.map(async (id) => {
    const data = await (await fetch(url + id)).json();
    const item = await data.response.body.items.item[0];
    const trip = {
      latitude: item.mapy,
      longitude: item.mapx,
      title: item.title,
      addr1: item.addr1,
      first_image: item.firstimage,
    };

    return trip;  
  });

  return [...trips];
}

getMyTrip();
