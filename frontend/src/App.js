import './App.css';
import ReactConcept from './components/ReactConcept';

function App() {
    const concepts = [
        { title: "Komponenty", description: "Popis 1" },
        { title: "Props", description: "Popis 2" },
        { title: "Stav", description: "Popis 3" },
        { title: "Životní cyklus", description: "Popis 4" }
    ];

    return (
        <div className="app">
            <h1>Základní koncepty Reactu</h1>
            {concepts.map((concept, index) => (
                <ReactConcept key={index} title={concept.title} description={concept.description} />
            ))}
        </div>
    );
}

export default App;
