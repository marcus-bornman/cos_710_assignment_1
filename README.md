<!-- PROJECT LOGO -->
<p align="right">
<a href="https://pub.dev">
<img src="https://raw.githubusercontent.com/marcus-bornman/cos_710_assignment_1/master/assets/project_badge.png" height="50" alt="Flutter">
</a>
</p>
<p align="center">
<img src="https://raw.githubusercontent.com/marcus-bornman/cos_710_assignment_1/master/assets/project_logo.png" height="100" alt="Masterpass Example" />
</p>

<!-- PROJECT SHIELDS -->
<p align="center">
<a href="https://github.com/marcus-bornman/cos_710_assignment_1/actions?query=workflow%3Abuild"><img src="https://img.shields.io/github/workflow/status/marcus-bornman/cos_710_assignment_1/build?label=build" alt="build"></a>
<a href="https://github.com/marcus-bornman/cos_710_assignment_1/issues"><img src="https://img.shields.io/github/issues/marcus-bornman/cos_710_assignment_1" alt="issues"></a>
<a href="https://github.com/marcus-bornman/cos_710_assignment_1/network"><img src="https://img.shields.io/github/forks/marcus-bornman/cos_710_assignment_1" alt="forks"></a>
<a href="https://github.com/marcus-bornman/cos_710_assignment_1/stargazers"><img src="https://img.shields.io/github/stars/marcus-bornman/cos_710_assignment_1" alt="stars"></a>
<a href="https://google.github.io/styleguide/javaguide.html"><img src="https://img.shields.io/badge/style-google_java-40c4ff.svg" alt="style"></a>
<a href="https://github.com/marcus-bornman/cos_710_assignment_1/blob/master/LICENSE"><img src="https://img.shields.io/github/license/Marcus-bornman/cos_710_assignment_1" alt="license"></a>
</p>

---

<!-- TABLE OF CONTENTS -->
## Table of Contents
* [About the Project](#about-the-project)
* [Getting Started](#getting-started)
* [Usage](#usage)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [License](#license)
* [Contact](#contact)
* [Acknowledgements](#acknowledgements)



<!-- ABOUT THE PROJECT -->
## About The Project
<p align="center">
<img src="https://raw.githubusercontent.com/marcus-bornman/cos_710_assignment_1/master/assets/screenshot_1.gif" width="800" alt="Screenshot 1" />
</p>

This assignment involves the implementation of a genetic programming approach to evolve a model for forecasting COVID-19
infections, deaths and recoveries for a particular day for a particular country. The covid_19_data.csv at https://www.kaggle.com/sudalairajkumar/novel-corona-virus-2019-dataset?select=covid_19_data.csv
is used to evaluate the genetic programming approach for forecasting COVID-19.

See the following for detailed information about the project:
* [specification.pdf](specification.pdf) - The specification for this assignment.
* [report.pdf](report/report.pdf) - The report submitted for this assignment.

### Built With
* [Java](https://www.java.com/en/)
* [Apache Maven](https://maven.apache.org)



<!-- GETTING STARTED -->
## Getting Started
To build this project you will need to have Java 1.8 or later installed as well as [Apache Maven](https://maven.apache.org).

You can ensure that the project compiles by running the following command in the root folder of this project:
```
mvn clean compile assembly:single
```



<!-- USAGE EXAMPLES -->
## Usage
To reproduce the results mentioned in [the report for this assignment](report/report.pdf), you simply need to run the
[reproduce.sh](reproduce.sh) script found in the root folder of this project:
```shell script
sh reproduce.sh
```
This will reproduce the output for 10 test runs in the [results folder](results).



<!-- ROADMAP -->
## Roadmap
See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of other proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the Academic Free License. See [LICENSE](LICENSE) for more information.



<!-- CONTACT -->
## Contact

Marcus Bornman - [marcusbornman.com](https://www.marcusbornman.com) - [marcus.bornman@gmail.com](mailto:marcus.bornman@gmail.com)

Project Link: [https://github.com/marcus-bornman/cos_710_assignment_1](https://github.com/marcus-bornman/cos_710_assignment_1)



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements
* [The ECJ Team](https://cs.gmu.edu/~eclab/projects/ecj/)
* [Shields IO](https://shields.io)
* [Open Source Licenses](https://choosealicense.com)