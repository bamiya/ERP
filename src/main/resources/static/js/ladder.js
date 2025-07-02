// === 설정 ===
const players = ["고등어","두부집","육전국밥","태백산맥","우사미","라멘"];
const results = ["다음에","다음에","다음에","다음에","다음에","당첨"];
const COLS = players.length;
const ROWS = 20;

const WIDTH = 600, HEIGHT = 500;
const MARGIN_X = 60, TOP_SPACE = 50, BOTTOM_SPACE = 50;

const canvas = document.getElementById("canvas");
const ctx = canvas.getContext("2d");
const layers = document.getElementById("layers");
const shuffleBtn = document.getElementById("shuffleBtn");

let hLines = [];
let colGap, rowGap;

// === 초기화 ===
function init() {
    colGap = (WIDTH - 2 * MARGIN_X) / (COLS - 1);
    rowGap = (HEIGHT - TOP_SPACE - BOTTOM_SPACE) / ROWS;
    shuffleBtn.addEventListener("click", drawLadder);
    drawLadder();
}
window.onload = init;

// === 사다리 그리기 ===
function drawLadder() {
    // 레이어 클리어
    layers.innerHTML = "";
    ctx.clearRect(0,0,WIDTH,HEIGHT);
    hLines = [];

    // 세로줄, 이름, 결과 배치
    for(let i=0;i<COLS;i++){
        const x = MARGIN_X + i*colGap;

        // 세로선
        const v = document.createElement("div");
        v.className = "line-vertical";
        v.style.left = `${x}px`;
        layers.appendChild(v);

        // 참가자 이름
        const p = document.createElement("div");
        p.className = "player-name";
        p.style.left = `${x-40}px`;
        p.textContent = players[i];
        p.dataset.idx = i;
        p.addEventListener("click", () => animatePath(i));
        layers.appendChild(p);

        // 결과
        const r = document.createElement("div");
        r.className = "result-name";
        r.style.left = `${x-40}px`;
        r.textContent = results[i];
        layers.appendChild(r);
    }

    // 가로줄 랜덤 배치
    for(let i=0;i<ROWS;i++){
        const col = Math.floor(Math.random()*(COLS-1));
        const x1 = MARGIN_X + col*colGap;
        const y = TOP_SPACE + i*rowGap;

        const h = document.createElement("div");
        h.className = "line-horizontal";
        h.style.left = `${x1}px`;
        h.style.top = `${y}px`;
        h.style.width = `${colGap}px`;
        layers.appendChild(h);

        hLines.push({x1, y, x2: x1+colGap});
    }
}

// === 애니메이션 경로 추적 ===
function animatePath(startIdx) {
    ctx.clearRect(0,0,WIDTH,HEIGHT);
    let x = MARGIN_X + startIdx*colGap;
    let y = TOP_SPACE;
    let idx = startIdx;

    // 시작점
    const path = [{x,y}];

    // 높이 순으로 가로줄 정렬
    const sorted = hLines.slice().sort((a,b)=>a.y-b.y);

    // 경로 만들기
    for(const h of sorted) {
        if(h.y >= y){
            // 수직 이동
            path.push({x, y: h.y});
            // 가로 이동
            if(Math.abs(x - h.x1) < 1) {
                x = h.x2; idx++;
            } else if(Math.abs(x - h.x2) < 1) {
                x = h.x1; idx--;
            }
            y = h.y;
            path.push({x,y});
        }
    }
    // 마지막 아래
    path.push({x, y: HEIGHT - BOTTOM_SPACE});

    // 애니메이션 그리기
    let step = 0;
    function drawStep() {
        if(step >= path.length-1) return;
        const p0 = path[step], p1 = path[step+1];
        let t = 0;
        function segment() {
            ctx.beginPath();
            ctx.moveTo(p0.x, p0.y);
            ctx.lineTo(p0.x + (p1.x-p0.x)*t, p0.y + (p1.y-p0.y)*t);
            ctx.strokeStyle = 'red';
            ctx.lineWidth = 3;
            ctx.stroke();
            t += 0.05;
            if(t<=1) requestAnimationFrame(segment);
            else {
                step++;
                drawStep();
            }
        }
        segment();
    }
    drawStep();
}
