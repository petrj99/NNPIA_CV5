import image1 from './assets/images/image1.jpg';
import image2 from './assets/images/image2.jpg';
import image3 from './assets/images/image3.jpg';
import image4 from './assets/images/image4.jpg';

export const data = [
    {
        title: 'Components',
        description: 'The core UI building block - compose the user interface by combining multiple components.',
        image: image1,
    },
    {
        title: 'JSX',
        description: 'Return (potentially dynamic) HTML(ish) code to define the actual markup that will be rendered.',
        image: image2,
    },
    {
        title: 'Props',
        description: 'Make components configurable (and therefore reusable) by passing input data to them.',
        image: image3,
    },
    {
        title: 'State',
        description: 'React-managed data which, when changed, causes the component to re-render & the UI to update.',
        image: image4,
    },
];