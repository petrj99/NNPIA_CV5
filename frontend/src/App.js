import './App.css';
import ReactConcept from './components/ReactConcept';
import { data } from './init-data';

function App() {
    return (
        <div className="app">
            <h1>Základní koncepty Reactu</h1>
            {data.map((concept, index) => (
                index % 2 === 0 ? (
                    // Klasické props a destructuring
                    <ReactConcept key={index} title={concept.title} description={concept.description} />
                ) : (
                    // Children prop
                    <ReactConcept key={index}>
                        <h2>{concept.title}</h2>
                        <p>{concept.description}</p>
                    </ReactConcept>
                )
            ))}
        </div>
    );
}

export default App;
