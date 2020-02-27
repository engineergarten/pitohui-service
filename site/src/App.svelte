<script>
	import Project from './Project.svelte';

	const project1 = {
		name: 'My Project',
    status: 'Active',
    tags: ['finance', 'open source', 'commerce'],
    description: 'bla bla',
    createDttm: '10/12/2020',
    links: ['https://tuda.shodi.com'],
    team: ['Human j. Developer'],
    analogs: [],
    techStack: 'shocaml, shavascrolls',
    lookingFor: ['frontend developer', 'sales', 'ceo', 'pomadchin']
	}
	const project2 = {
		name: 'Her Project',
    status: 'Active',
    tags: ['finance', 'open source', 'commerce', 'beginner friendly'],
    description: 'Mir nikogda ne budet prezhnim',
    createDttm: '24/12/2020',
    links: ['https://change.world.org'],
    team: ['Catty Purr'],
    analogs: [],
    techStack: 'stoplang, writescrolls',
    lookingFor: ['backend developers', 'pomadchin']
	}
</script>

<main>
	<Project {...project1}/>
	<Project {...project2}/>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>