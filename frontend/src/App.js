import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import ReactConcept from './components/ReactConcept';
import { data } from './init-data';

function App() {
    return (
        <div className="container">
            <div className="row">
                {data.map((concept, index) => (
                    <div key={index} className="col-sm-12 col-md-6 col-lg-4">
                        <ReactConcept
                            title={concept.title}
                            description={concept.description}
                            image={concept.image}
                        />
                    </div>
                ))}
            </div>
        </div>
    );
}

export default App;
