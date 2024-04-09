import './App.css';
import ReactConcept from './components/ReactConcept';
import { data } from './init-data';

function App() {
    return (
        <div className="app">
            <h1>Základní koncepty Reactu</h1>
            <ReactConcept title={data[0].title} description={data[0].description} />
            <ReactConcept title={data[1].title} description={data[2].description} />
            <ReactConcept title={data[2].title} description={data[2].description} />
            <ReactConcept title={data[3].title} description={data[3].description} />
        </div>
    );
}

export default App;
