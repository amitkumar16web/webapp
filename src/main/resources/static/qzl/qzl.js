// select all elements
const start = document.getElementById("start");
const quiz = document.getElementById("quiz");
const question = document.getElementById("question");
const qImg = document.getElementById("qImg");
const choiceA = document.getElementById("A");
const choiceB = document.getElementById("B");
const choiceC = document.getElementById("C");
const counter = document.getElementById("counter");
const timeGauge = document.getElementById("timeGauge");
const progress = document.getElementById("progress");
const scoreDiv = document.getElementById("scoreContainer");

// create our questions
let questions = [
    {
        question : "1: Which company is represented by the below logo?",
        imgSrc : "qzl/qsn/q1.png",
        choiceA : "Philips",
        choiceB : "Syska",
        choiceC : "Girish",
        correct : "A"
    },{
        question : "2: Which company is represented by the below logo?",
        imgSrc : "qzl/qsn/q2.png",
        choiceA : "BMD",
        choiceB : "Volkswagen",
        choiceC : "Mercedes Benz",
        correct : "A"
    },{
        question : "3: Which company is represented by the below logo?",  

        imgSrc : "qzl/qsn/q3.png",
        choiceA : "Fadero OS",
        choiceB : "Suse OS",
        choiceC : "Rad Hat OS",
        correct : "B"
    },{
        question : "4: Which company is represented by the below logo?",  
        imgSrc : "qzl/qsn/q4.png",
        choiceA : "Delloite",
        choiceB : "BPTP",
        choiceC : "CISCO",   
        correct : "C"
    },{
        question : "5: Which company is represented by the below logo?",  
        imgSrc : "qzl/qsn/q5.png",
        choiceA : "Blue Pipes",
        choiceB : "Fedora",
        choiceC : "Rad Had",   
        correct : "B"
    },{
        question : "6: Which company is represented by the below logo?",  
        imgSrc : "qzl/qsn/q6.png",
        choiceA : "Steel Authority of India",
        choiceB : "Bharat Heavy Electricals Ltd.",
        choiceC : "National Thermal Power Corporation",   
        correct : "A"
    },{
        question : "7: Which Programming Language is represented by the below logo?",  
        imgSrc : "qzl/qsn/q7.png",
        choiceA : "Kotlin",
        choiceB : "Rust",
        choiceC : "Golang",   
        correct : "C"
    },{
        question : "8: Which company is represented by the below logo?",      
        imgSrc : "qzl/qsn/q8.png",
        choiceA : "Lamborghini",
        choiceB : "Bull Fighting",
        choiceC : "Golden Bull",   
        correct : "A"
    },{
        question : "9: Which company is represented by the below logo?",       
        imgSrc : "qzl/qsn/q9.png",
        choiceA : "Red Label",
        choiceB : "Aircel",
        choiceC : "Power Life",   
        correct : "B"
    },{
        question : "10: Which Programming Language is represented by the below logo?",       
        imgSrc : "qzl/qsn/q10.png",
        choiceA : "Java",
        choiceB : "PHP",
        choiceC : "Javascript",   
        correct : "A"
    }


];

// create some variables

const lastQuestion = questions.length - 1;
let runningQuestion = 0;
let count = 0;
const questionTime = 90; // 10s
const gaugeWidth = 150; // 150px
const gaugeUnit = gaugeWidth / questionTime;
let TIMER;
let score = 0;

// render a question
function renderQuestion(){
    let q = questions[runningQuestion];
    
    question.innerHTML = "<p>"+ q.question +"</p>";
    qImg.innerHTML = "<img src="+ q.imgSrc +">";
    choiceA.innerHTML = q.choiceA;
    choiceB.innerHTML = q.choiceB;
    choiceC.innerHTML = q.choiceC;
}

start.addEventListener("click",startQuiz);

// start quiz
function startQuiz(){
    start.style.display = "none";
    renderQuestion();
    quiz.style.display = "block";
    renderProgress();
    renderCounter();
    TIMER = setInterval(renderCounter,1000); // 1000ms = 1s
}

// render progress
function renderProgress(){
    for(let qIndex = 0; qIndex <= lastQuestion; qIndex++){
        progress.innerHTML += "<div class='prog' id="+ qIndex +"></div>";
    }
}

// counter render

function renderCounter(){
    if(count <= questionTime){
        counter.innerHTML = count;
        timeGauge.style.width = count * gaugeUnit + "px";
        count++
    }else{
        count = 0;
        // change progress color to red
        answerIsWrong();
        if(runningQuestion < lastQuestion){
            runningQuestion++;
            renderQuestion();
        }else{
            // end the quiz and show the score
            clearInterval(TIMER);
            scoreRender();
        }
    }
}

// checkAnwer

function checkAnswer(answer){
    if( answer == questions[runningQuestion].correct){
        // answer is correct
        score++;
        // change progress color to green
        answerIsCorrect();
    }else{
        // answer is wrong
        // change progress color to red
        answerIsWrong();
    }
    count = 0;
    if(runningQuestion < lastQuestion){
        runningQuestion++;
        renderQuestion();
    }else{
        // end the quiz and show the score
        clearInterval(TIMER);
        scoreRender();
    }
}

// answer is correct
function answerIsCorrect(){
    document.getElementById(runningQuestion).style.backgroundColor = "#0f0";
}

// answer is Wrong
function answerIsWrong(){
    document.getElementById(runningQuestion).style.backgroundColor = "#f00";
}

// score render
function scoreRender(){
    scoreDiv.style.display = "block";
    
    // calculate the amount of question percent answered by the user
    const scorePerCent = Math.round(100 * score/questions.length);
    
    // choose the image based on the scorePerCent
    let img = (scorePerCent >= 80) ? "qzl/5.png" :
              (scorePerCent >= 60) ? "qzl/4.png" :
              (scorePerCent >= 40) ? "qzl/3.png" :
              (scorePerCent >= 20) ? "qzl/2.png" :
              "qzl/1.png";
    
    scoreDiv.innerHTML = "<img src="+ img +">";
    scoreDiv.innerHTML += "<p>"+ scorePerCent +"%</p>";
}





















