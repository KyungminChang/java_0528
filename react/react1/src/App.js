import './css/App.css'//css 폴더에 App.css가 있고, 연결할 때 사용
import {useState} from 'react';
import Button from "./Button";
function App() {
   //arr1을 복사해서 arr2를 만들고 싶어서 다음과 같이 했더니 원하는 결과가 나타나지 않음
   var arr1 = [1,2,3];
   console.log(arr1);
   var arr2 = arr1; 
   console.log(arr2); 
   arr2.push(4);//arr2에 4를 추가했더니
   console.log(arr1);//arr1에 4가 같이 추가 (같이 추가됐다기 보다는 하나를 공유했기 때문에 발생한 결과)
   console.log('---------------------------------------------');
   //arr3를 복사해서 arr4를 만들고 싶어서 전개 연산자를 사용했더니 원하는 결과가 나옴
   var arr3 = [1,2,3];
   console.log(arr3);
   var arr4 = [...arr3];//전개 연산자 : 배열이나 객체를 복사할 때 사용
   console.log(arr4);
   arr4.push(4);
   console.log(arr3);
/*
   appleCount라는 변수에 arr5에 있는 1이 저장되고,
   bananaCount 변수에 arr5에 있는 2가 저장되고,
   orangeCount 변수에 arr5에 있는 3이 저장되도록 작성
   => 번지를 이용해서 해도 되지만, 변수 선언 시 []안에 각 변수명을 써주면
   해당 번지에 맞는 값들이 변수에 맵핑이 됨
*/
   var arr5 = [1, 2, 3];
   var [appleCount, bananaCount, orangeCount] = arr5;
   console.log('appleCount : ' + appleCount,'bananaCount : ' + bananaCount, 'orangeCount : ' + orangeCount);
   var [text1, text2] = ['버튼on','버튼off'];
   //var on = true;
   var [on, setOn] = useState(true);
   var [input, setInput] = useState("");

   function btnOnClick(){
    alert('On button click');
    setOn(false);
    console.log(on);
   }
   function btnOffClick(){
    alert('Off button click');
    setOn(true);
    console.log(on);
   }
   function change(e){
      //인풋창에 입력된 값을 가져옴
      var value = e.target.value;
      //가져온 입력값으로 unput 스테이트 변수값을 가져옴
      setInput(value);
   }

  return (
    <div>
     {on ? <Button text={text1} type={"button"} className={"btn"} click={btnOnClick}/> : ''}
     {!on ? <Button text={text2} type={"submit"} className={"btn"} click={btnOffClick}/> : ''}
     {/*<Button text="버튼입니다." type="submit" className={{a:"a"}}/>*/}
     <br/>
     <input type="text" onChange={change}/>
     <h1>{input}</h1>
    </div>
  );
}

export default App;
