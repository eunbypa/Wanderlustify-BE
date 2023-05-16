// 공공데이터 서비스 키
const serviceKey =
  "MsJ8m3KE1BZRPPU4a%2B4glQobhuo6032W3s7fL90AnUrHal0TqMrveuvQyEEs%2FP9VexVGAo%2BvJSn%2B1RtSF2DBFQ%3D%3D";

// 지역코드
const areaUrl =
  "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
  serviceKey +
  "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";

// 공공데이터 시도 코드 호출
async function fetchOption() {
  const sidoUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json`;
  const response = await fetch(sidoUrl);
  const data = await response.json();
  makeOption(data);
}

// 시도 뷰 생성
function makeOption(data) {
  let areas = data.response.body.items.item;
  let sel = document.getElementById("search-area");
  areas.forEach((area) => {
    let opt = document.createElement("option");
    opt.setAttribute("value", area.code);
    opt.appendChild(document.createTextNode(area.name));
    sel.appendChild(opt);
  });
}

// 공공데이터 구군 코드 호출
async function fetchGuGunOption(areaCode) {
  const gugunUrl = `https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=${serviceKey}&MobileOS=ETC&MobileApp=AppTest&_type=json&areaCode=${areaCode}`;

  const response = await fetch(gugunUrl);
  const data = await response.json();
  makeGuGunOption(data);
}

// 구군 뷰 생성
function makeGuGunOption(data) {
  const item = data.response.body.items.item;
  const $sel = document.getElementById("search-area-gugun");
  $sel.innerHTML = "";

  item.forEach((gugun) => {
    const $opt = document.createElement("option");
    $opt.setAttribute("value", gugun.code);
    $opt.appendChild(document.createTextNode(gugun.name));

    $sel.append($opt);
  });
}

window.onload = function () {
  init();
  fetchOption();
  fetchGuGunOption(1);
  document
    .getElementById("search-area")
    ?.addEventListener("change", (e) => fetchGuGunOption(e.target.value));
  document.getElementById("btn-search").addEventListener("click", (e) => {
    e.preventDefault();
    fetchAttraction();
  });
};

// 공공데이터 여행지 호출
async function fetchAttraction() {
  let areaCode = document.getElementById("search-area").value;
  let contentTypeId = document.getElementById("search-content-id").value;
  let gugunCode = document.getElementById("search-area-gugun").value;

  let searchUrl = `https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=${serviceKey}&contentTypeId=${contentTypeId}&areaCode=${areaCode}&sigunguCode=${gugunCode}&MobileOS=ETC&MobileApp=TestApp&_type=json&numOfRows=20`;

  const response = await fetch(searchUrl);
  const data = await response.json();
  makeList(data.response.body.items.item);
}

function add(dataset) {
  const { contentid } = dataset;
  console.log(contentid);
  fetch(`/attraction/addMyTrip?contentId=${contentid}`);
}
