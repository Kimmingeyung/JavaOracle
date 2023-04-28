
import React, {useState, useEffect, useRef} from "react";
import { useNavigate } from "react-router";
import'./main.css'; 
import MovieItem from "./MovieItem";

function MovieList(){
    const[movieList,setMovieList] = useState([]);
    const navigate = useNavigate();
    //제목? 검색
    const title = useRef();

    function getMovieList(url) {
        fetch(url) 
            .then(response => {return response.json();})
            .then(data => {setMovieList(data); })

    }
    //서버와 연결
    useEffect(() => {getMovieList('/findAllMovies')}, []); 
    //==> MovieList가 로드되었을 때 최초 1회만 호출
    
    
    //js문법
    return (
        <div>
            <h2>영화 리스트</h2>
            타이틀: <input name="title" ref={title} onKeyDown ={(event) => {
                if (event.key == 'Enter') {
                    if(title.current.value == '') {
                        alert('제목을 입력하세요');
                        return false;
                    }
                    getMovieList(`/findByTitle/${title.current.value}`);
                }
            }}/>
            <button type='button' onClick={() => {
                if(title.current.value == '') {
                    alert('제목을 입력하세요');
                    return false;
                }
                getMovieList(`/findByTitle/${title.current.value}`);
                
            }}>조회</button> <br/><br/>
            <div>총{movieList.length}편</div>
            <button type="button" onClick={()=> navigate('/writeMovie')}>영화 등록</button>
            <div style={{
                display: 'grid',
                gridTemplateRows: '1fr',
                gridTemplateColumns : '1fr 1fr 1fr 1fr'
            }}>
                {movieList.map(
                    ({movie_id, title, price})=>(
                        <MovieItem movie_id={movie_id}
                            title={title}
                            price={price}/>
                    )
                )}
            </div>
        </div>
    )
}
export default MovieList;



